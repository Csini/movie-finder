package hu.exercise.movie.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.omdbapi.openapi.client.api.SearchParameterApi;
import com.omdbapi.openapi.client.model.TitleSearch200Response;

import hu.exercise.movie.entity.CallSearchMovie;
import hu.exercise.movie.openapi.api.ApiApiDelegate;
import hu.exercise.movie.openapi.model.MovieResponse;
import hu.exercise.movie.service.CallSearchMovieService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ApiDeledateController implements ApiApiDelegate {

	private ModelMapper beanMapper;

	private CallSearchMovieService callSearchMovieService;

	private SearchParameterApi searchParameterApi;

	public ApiDeledateController(@Autowired ModelMapper beanMapper,
			@Autowired CallSearchMovieService callSearchMovieService, @Autowired SearchParameterApi searchParameterApi) {
		super();
		this.beanMapper = beanMapper;
		this.callSearchMovieService = callSearchMovieService;
		
		this.searchParameterApi = searchParameterApi;
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
		return ApiApiDelegate.super.searchTheMoviedb(movieTitle);
	}
}
