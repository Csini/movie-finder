package hu.exercise.movie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.themoviedb.openapi.client.api.DefaultApi;
import org.themoviedb.openapi.client.model.MovieCredits200Response;
import org.themoviedb.openapi.client.model.MovieDetails200Response;
import org.themoviedb.openapi.client.model.SearchMovie200Response;
import org.themoviedb.openapi.client.model.SearchMovie200ResponseResultsInner;

import hu.exercise.movie.config.RedisConfiguration;
import hu.exercise.movie.entity.CallSearchMovie;
import hu.exercise.movie.openapi.model.Movie;
import hu.exercise.movie.openapi.model.MovieResponse;

@Controller
public class TmdbController {

	@Autowired
	private DefaultApi defaultApi;
	
	@Cacheable(value = RedisConfiguration.TMDB_CACHE_NAME)
	public MovieResponse search(String movieTitle) {

		// extra check from api-key
//		defaultApi.authenticationValidateKey();

		// call MovieService
		SearchMovie200Response searchMovieResult = callSearchMovie(movieTitle);

		MovieResponse response = handleSearchMovie200Response(searchMovieResult);

		return response;
	}
	
	protected MovieResponse handleSearchMovie200Response(SearchMovie200Response searchMovieResult) {
		MovieResponse response = new MovieResponse();

		searchMovieResult.getResults().stream().map((SearchMovie200ResponseResultsInner result) -> {

			//not needed
//			MovieDetails200Response movieDetails = callMovieDetails(result.getId());
			
			// year
//			String releaseDate = movieDetails.getReleaseDate();
			String releaseDate =result.getReleaseDate();

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

			return Movie.builder().title(result.getTitle()).year(releaseDate).director(directors).build();
		}).forEach(moviesItem -> response.addMoviesItem(moviesItem));
		
		response.setSize((long)response.getMovies().size());
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
