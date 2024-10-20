package hu.exercise.movie.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.omdbapi.openapi.client.api.SearchParameterApi;
import com.omdbapi.openapi.client.model.SearchResponse;
import com.omdbapi.openapi.client.model.TitleSearch200Response;

import hu.exercise.movie.config.RedisConfiguration;
import hu.exercise.movie.openapi.model.Movie;
import hu.exercise.movie.openapi.model.MovieResponse;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class OmdbController {

	@Autowired
	private SearchParameterApi searchParameterApi;

	@Cacheable(value = RedisConfiguration.OMDB_CACHE_NAME)
	public MovieResponse search(String movieTitle) throws JsonProcessingException, ClassCastException {

		// call MovieService
		Object titleSearch = searchParameterApi.titleSearch(movieTitle, null, null, null, null, null);

		MovieResponse response = new MovieResponse();
		try {
			SearchResponse searchResponse = TitleSearch200Response.getSearchResponse(titleSearch);
			handleSearchResponse(response, searchResponse);
		} catch (ClassCastException e) {
			log.warn("handleTitleSearch200Response", e);
			List<SearchResponse> listSearchResponse = TitleSearch200Response.getListSearchResponse(titleSearch);
			handleListSearchResponse(response, listSearchResponse);
		}
		response.setSize((long) response.getMovies().size());
		return response;
	}

	protected void handleListSearchResponse(MovieResponse response, List<SearchResponse> listSearchResponse) {
		listSearchResponse.forEach(searchResponse -> handleSearchResponse(response, searchResponse));
	}

	protected void handleSearchResponse(MovieResponse response, SearchResponse searchResponse) {
		response.addMoviesItem(Movie.builder().title(searchResponse.getTitle()).year(searchResponse.getYear())
				.director(Arrays.asList(searchResponse.getDirector())).build());
	}
}
