package hu.exercise.movie.controller;

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

	private ModelMapper beanMapper;

	private CallSearchMovieService callSearchMovieService;

	private SearchParameterApi searchParameterApi;

	private DefaultApi defaultApi;

	public ApiDeledateController(@Autowired ModelMapper beanMapper,
			@Autowired CallSearchMovieService callSearchMovieService, @Autowired SearchParameterApi searchParameterApi,
			@Autowired DefaultApi defaultApi) {
		super();
		this.beanMapper = beanMapper;
		this.callSearchMovieService = callSearchMovieService;

		this.searchParameterApi = searchParameterApi;

		this.defaultApi = defaultApi;
	}

	public void setBeanMapper(ModelMapper beanMapper) {
		this.beanMapper = beanMapper;
	}

	@Override
	public ResponseEntity<MovieResponse> searchOmdb(String movieTitle) {

		callSearchMovieService.save(CallSearchMovie.omdb().movieTitle(movieTitle).build());

		// TODO call MovieService
		TitleSearch200Response titleSearch = searchParameterApi.titleSearch(movieTitle, null, null, null, null, null);

//		titleSearch.

		return ApiApiDelegate.super.searchOmdb(movieTitle);
	}

	@Override
	public ResponseEntity<MovieResponse> searchTheMoviedb(String movieTitle) {

		callSearchMovieService.save(CallSearchMovie.themoviedb().movieTitle(movieTitle).build());

		// TODO call MovieService
		defaultApi.authenticationValidateKey();

		MovieResponse response = new MovieResponse();

		boolean includeAdult = true;
		SearchMovie200Response searchMovieResult = defaultApi.searchMovie(movieTitle, includeAdult, null, null, null,
				null, null);

		for (SearchMovie200ResponseResultsInner result : searchMovieResult.getResults()) {

			MovieDetails200Response movieDetails = defaultApi.movieDetails(result.getId(), null, null);

			// year
			String releaseDate = movieDetails.getReleaseDate();

			Movie moviesItem = new Movie();
			response.addMoviesItem(moviesItem);

			moviesItem.setTitle(movieDetails.getTitle());

			// format to year
			// "release_date": "1999-10-15",
			if (!StringUtils.isEmpty(releaseDate) && releaseDate.length() >= 4) {
				releaseDate = releaseDate.substring(0, 4);
			}
			moviesItem.setYear(releaseDate);

			MovieCredits200Response movieCredits = defaultApi.movieCredits(result.getId(), null);

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

			// directors
			List<String> directors = movieCredits.getCrew().stream()
					.filter(crew -> "Directing".equals(crew.getKnownForDepartment())).map(crew -> crew.getName())
					// .collect( Collectors.joining( ", " ) );
					.collect(Collectors.toList());
			moviesItem.setDirector(directors);
		}

//		return ApiApiDelegate.super.searchTheMoviedb(movieTitle);
		return ResponseEntity.ok(response);
	}
}
