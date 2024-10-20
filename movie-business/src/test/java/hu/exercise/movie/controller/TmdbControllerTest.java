package hu.exercise.movie.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.themoviedb.openapi.client.model.MovieCredits200Response;
import org.themoviedb.openapi.client.model.MovieCredits200ResponseCrewInner;
import org.themoviedb.openapi.client.model.MovieDetails200Response;
import org.themoviedb.openapi.client.model.SearchMovie200Response;
import org.themoviedb.openapi.client.model.SearchMovie200ResponseResultsInner;

import hu.exercise.movie.openapi.model.Movie;
import hu.exercise.movie.openapi.model.MovieResponse;

public class TmdbControllerTest extends TmdbController {

	@Test
	public void test_handleSearchMovie200Response() {
		SearchMovie200Response inputList = new SearchMovie200Response();
		SearchMovie200ResponseResultsInner input1 = new SearchMovie200ResponseResultsInner();
		input1.setTitle("xxxx");
		input1.setReleaseDate("1901-12-07");
		input1.setId(1);
		inputList.addResultsItem(input1);

		SearchMovie200ResponseResultsInner input2 = new SearchMovie200ResponseResultsInner();
		input2.setTitle("aaaaa");
		input2.setReleaseDate("1977-02-14");
		input2.setId(2);
		inputList.addResultsItem(input2);

		MovieResponse output = handleSearchMovie200Response(inputList);

		Assertions.assertEquals(2, output.getMovies().size());

		Movie movie1 = output.getMovies().get(0);
		Assertions.assertEquals(input1.getTitle(), movie1.getTitle());
		Assertions.assertEquals("aaa", movie1.getDirector().get(0));
		Assertions.assertEquals("1901", movie1.getYear());

		Movie movie2 = output.getMovies().get(1);
		Assertions.assertEquals(input2.getTitle(), movie2.getTitle());
		Assertions.assertEquals("bbb", movie2.getDirector().get(0));
		Assertions.assertEquals("1977", movie2.getYear());
	}

	@Override
	protected MovieCredits200Response callMovieCredits(int id) {
		MovieCredits200Response response = new MovieCredits200Response();
		if (id == 1) {
			MovieCredits200ResponseCrewInner crewItem = new MovieCredits200ResponseCrewInner();
			crewItem.setJob("Director");
			crewItem.setName("aaa");
			response.addCrewItem(crewItem);
			return response;
		} else if (id == 2) {
			MovieCredits200ResponseCrewInner crewItem = new MovieCredits200ResponseCrewInner();
			crewItem.setJob("Director");
			crewItem.setName("bbb");
			response.addCrewItem(crewItem);

			MovieCredits200ResponseCrewInner crewItem2 = new MovieCredits200ResponseCrewInner();
			crewItem2.setJob("Actor");
			crewItem2.setName("ccc");
			response.addCrewItem(crewItem2);

			return response;
		}
		throw new RuntimeException("id " + id + " is unexpected, not mocked.");
	}

	@Override
	protected MovieDetails200Response callMovieDetails(int id) {
		// TODO not needed
		return super.callMovieDetails(id);
	}

}
