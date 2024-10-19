package hu.exercise.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.exercise.movie.entity.CallSearchMovie;
import hu.exercise.movie.repository.CallSearchMovieRepository;
import hu.exercise.movie.service.CallSearchMovieService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CallSearchMovieServiceImpl implements CallSearchMovieService {

	private CallSearchMovieRepository repository;

	public CallSearchMovieServiceImpl(@Autowired CallSearchMovieRepository repository) {
		super();
		this.repository = repository;
	}

	public void setRepository(CallSearchMovieRepository repository) {
		this.repository = repository;
	}

	@Override
	public CallSearchMovie save(CallSearchMovie callSearchMovie) {
		return repository.saveAndFlush(callSearchMovie);
	}
}
