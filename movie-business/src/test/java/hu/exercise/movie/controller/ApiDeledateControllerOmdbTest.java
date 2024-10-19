package hu.exercise.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.omdbapi.openapi.client.model.SearchResponse;
import com.omdbapi.openapi.client.model.TitleSearch200Response;
import com.omdbapi.openapi.client.model.TitleSearch200Response;

import hu.exercise.movie.openapi.model.Movie;
import hu.exercise.movie.openapi.model.MovieResponse;

public class ApiDeledateControllerOmdbTest extends ApiDeledateController {

	@Test
	public void test_handleTitleSearch200Response_SearchResponse() {
		SearchResponse input = new SearchResponse();
		input.setTitle("xxxx");
		input.setDirector("zzz");
		input.setYear("1901");
		MovieResponse output = handleTitleSearch200Response(input);

		Assertions.assertEquals(1, output.getMovies().size());

		Movie movie = output.getMovies().get(0);
		Assertions.assertEquals(input.getTitle(), movie.getTitle());
		Assertions.assertEquals(input.getDirector(), movie.getDirector().get(0));
		Assertions.assertEquals(input.getYear(), movie.getYear());
	}
	
	@Test
	public void test_handleTitleSearch200Response_List() {
		TitleSearch200Response inputList = new TitleSearch200Response();
		SearchResponse input1 = new SearchResponse();
		input1.setTitle("xxxx");
		input1.setDirector("zzz");
		input1.setYear("1901");
		inputList.add(input1);
		
		SearchResponse input2 = new SearchResponse();
		input2.setTitle("aaaaa");
		input2.setDirector("bbbb");
		input2.setYear("1977");
		inputList.add(input2);
		
		MovieResponse output = handleTitleSearch200Response(inputList);

		Assertions.assertEquals(2, output.getMovies().size());

		Movie movie1 = output.getMovies().get(0);
		Assertions.assertEquals(input1.getTitle(), movie1.getTitle());
		Assertions.assertEquals(input1.getDirector(), movie1.getDirector().get(0));
		Assertions.assertEquals(input1.getYear(), movie1.getYear());
		
		Movie movie2 = output.getMovies().get(1);
		Assertions.assertEquals(input2.getTitle(), movie2.getTitle());
		Assertions.assertEquals(input2.getDirector(), movie2.getDirector().get(0));
		Assertions.assertEquals(input2.getYear(), movie2.getYear());
	}

}
