package hu.exercise.movie.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.themoviedb.openapi.client.api.DefaultApi;
import org.themoviedb.openapi.client.model.MovieCredits200Response;
import org.themoviedb.openapi.client.model.MovieDetails200Response;
import org.themoviedb.openapi.client.model.SearchMovie200Response;
import org.themoviedb.openapi.client.model.SearchMovie200ResponseResultsInner;

import com.omdbapi.openapi.client.api.SearchParameterApi;
import com.omdbapi.openapi.client.model.SearchResponse;
import com.omdbapi.openapi.client.model.TitleSearch200Response;

import hu.exercise.movie.entity.CallSearchMovie;
import hu.exercise.movie.openapi.api.ApiApiDelegate;
import hu.exercise.movie.openapi.model.Movie;
import hu.exercise.movie.openapi.model.MovieResponse;
import hu.exercise.movie.service.CallSearchMovieService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ApiDeledateController implements ApiApiDelegate {

	@Autowired
	private ModelMapper beanMapper;

	@Autowired
	private CallSearchMovieService callSearchMovieService;

	@Autowired
	private SearchParameterApi searchParameterApi;

	@Autowired
	private DefaultApi defaultApi;

	public void setBeanMapper(ModelMapper beanMapper) {
		this.beanMapper = beanMapper;
	}

	@Override
	public ResponseEntity<MovieResponse> searchOmdb(String movieTitle) {

		callSearchMovieService.save(CallSearchMovie.omdb().movieTitle(movieTitle).build());

		// call MovieService
		TitleSearch200Response titleSearch = searchParameterApi.titleSearch(movieTitle, null, null, null, null, null);

		MovieResponse response = handleTitleSearch200Response(titleSearch);

		return ResponseEntity.ok(response);
	}

	protected MovieResponse handleTitleSearch200Response(TitleSearch200Response titleSearch) {
		MovieResponse response = new MovieResponse();
		try {
			SearchResponse searchResponse = titleSearch.getSearchResponse();
			handleSearchResponse(response, searchResponse);
		} catch (ClassCastException e) {
			titleSearch.getListSearchResponse()
					.forEach(searchResponse -> handleSearchResponse(response, searchResponse));
		}
		return response;
	}

	protected void handleSearchResponse(MovieResponse response, SearchResponse searchResponse) {
		response.addMoviesItem(Movie.builder().title(searchResponse.getTitle()).year(searchResponse.getYear())
				.director(Arrays.asList(searchResponse.getDirector())).build());
	}

	@Override
	public ResponseEntity<MovieResponse> searchTheMoviedb(String movieTitle) {

		callSearchMovieService.save(CallSearchMovie.themoviedb().movieTitle(movieTitle).build());

		// extra check from api-key
//		defaultApi.authenticationValidateKey();

		// call MovieService
		SearchMovie200Response searchMovieResult = callSearchMovie(movieTitle);

		MovieResponse response = handleSearchMovie200Response(searchMovieResult);

		return ResponseEntity.ok(response);
	}

	protected MovieResponse handleSearchMovie200Response(SearchMovie200Response searchMovieResult) {
		MovieResponse response = new MovieResponse();

		searchMovieResult.getResults().stream().map((SearchMovie200ResponseResultsInner result) -> {

			MovieDetails200Response movieDetails = callMovieDetails(result.getId());

			// year
			String releaseDate = movieDetails.getReleaseDate();

			// format to year
			// "release_date": "1999-10-15",
			if (!StringUtils.isEmpty(releaseDate) && releaseDate.length() >= 4) {
				releaseDate = releaseDate.substring(0, 4);
			}

			MovieCredits200Response movieCredits = callMovieCredits(result.getId());

//			 {
//			      "adult": false,
//			      "gender": 2,
//			      "id": 5714,
//			      "known_for_department": "Directing",
//			      "name": "Carlos Saldanha",
//			      "original_name": "Carlos Saldanha",
//			      "popularity": 2.797,
//			      "profile_path": "/oxUlCSgxKaoCRYFyS65PC2fZWrk.jpg",
//			      "credit_id": "5894cedb92514122b50000e4",
//			      "department": "Visual Effects",
//			      "job": "Animation Supervisor"
//			    },
//			 {
//			      "adult": false,
//			      "gender": 2,
//			      "id": 7467,
//			      "known_for_department": "Directing",
//			      "name": "David Fincher",
//			      "original_name": "David Fincher",
//			      "popularity": 18.371,
//			      "profile_path": "/tpEczFclQZeKAiCeKZZ0adRvtfz.jpg",
//			      "credit_id": "631f0289568463007bbe28a5",
//			      "department": "Directing",
//			      "job": "Director"
//			    },

			// directors
			List<String> directors = movieCredits.getCrew().stream().filter(crew -> "Director".equals(crew.getJob()))
					.map(crew -> crew.getName()).collect(Collectors.toList());

			return Movie.builder().title(movieDetails.getTitle()).year(releaseDate).director(directors).build();
		}).forEach(moviesItem -> response.addMoviesItem(moviesItem));
		return response;
	}

	protected SearchMovie200Response callSearchMovie(String movieTitle) {

		boolean includeAdult = true;
		return defaultApi.searchMovie(movieTitle, includeAdult, null, null, null, null, null);
	}

	protected MovieCredits200Response callMovieCredits(int id) {
		return defaultApi.movieCredits(id, null);
	}

	protected MovieDetails200Response callMovieDetails(int id) {
		return defaultApi.movieDetails(id, null, null);
	}
}
