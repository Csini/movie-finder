package hu.exercise.movie.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import hu.exercise.movie.openapi.api.ApiApiDelegate;
import hu.exercise.movie.openapi.model.MovieResponse;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ApiDeledateController implements ApiApiDelegate {

	private ModelMapper beanMapper;

	public ApiDeledateController(@Autowired ModelMapper beanMapper) {
		super();
		this.beanMapper = beanMapper;
	}

	public void setBeanMapper(ModelMapper beanMapper) {
		this.beanMapper = beanMapper;
	}

	@Override
	public ResponseEntity<MovieResponse> searchOmdbByMovieName(String movieName) {
		// TODO call MovieService
		return ApiApiDelegate.super.searchOmdbByMovieName(movieName);
	}
	
	@Override
	public ResponseEntity<MovieResponse> searchTheMoviedbByMovieName(String movieName) {
		// TODO call MovieService
		return ApiApiDelegate.super.searchTheMoviedbByMovieName(movieName);
	}
}
