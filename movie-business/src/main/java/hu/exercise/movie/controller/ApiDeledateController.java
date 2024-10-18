package hu.exercise.movie.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import hu.exercise.movie.openapi.api.MovieNameApiDelegate;
import hu.exercise.movie.openapi.model.MovieResponse;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ApiDeledateController implements MovieNameApiDelegate {

	private ModelMapper beanMapper;

	public ApiDeledateController(@Autowired ModelMapper beanMapper) {
		super();
		this.beanMapper = beanMapper;
	}

	public void setBeanMapper(ModelMapper beanMapper) {
		this.beanMapper = beanMapper;
	}

	@Override
	public ResponseEntity<MovieResponse> searchByMovieName(String apiName, String movieName) {
		// TODO call MovieService
		return MovieNameApiDelegate.super.searchByMovieName(apiName, movieName);
	}
}
