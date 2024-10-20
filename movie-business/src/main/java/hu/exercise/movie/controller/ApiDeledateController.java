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

import com.fasterxml.jackson.core.JsonProcessingException;
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
	
	// db statistic about calls
	@Autowired
	private CallSearchMovieService callSearchMovieService;

	@Autowired
	OmdbController omdbController;
	
	@Autowired
	TmdbController tmdbController;

	public void setBeanMapper(ModelMapper beanMapper) {
		this.beanMapper = beanMapper;
	}

	@Override
	public ResponseEntity<MovieResponse> searchOmdb(String movieTitle) throws ClassCastException {

		callSearchMovieService.save(CallSearchMovie.omdb().movieTitle(movieTitle).build());

		MovieResponse response;
		try {
			response = omdbController.search(movieTitle);
		} catch (JsonProcessingException | ClassCastException e) {
			log.error("searchOmdb", e);
			return ResponseEntity.internalServerError().build();
		}

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<MovieResponse> searchTheMoviedb(String movieTitle) {

		callSearchMovieService.save(CallSearchMovie.themoviedb().movieTitle(movieTitle).build());

		MovieResponse response = tmdbController.search(movieTitle);

		return ResponseEntity.ok(response);
	}

}
