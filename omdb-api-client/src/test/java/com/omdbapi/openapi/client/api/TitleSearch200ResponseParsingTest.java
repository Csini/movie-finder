package com.omdbapi.openapi.client.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.omdbapi.openapi.client.model.SearchResponse;
import com.omdbapi.openapi.client.model.TitleSearch200Response;

/**
 * API tests for TitleSearch200ResponseParsing
 */
class TitleSearch200ResponseParsingTest {

	@Test
	void testOneResult() throws HttpMessageNotReadableException, IOException {

//     MappingJackson2HttpMessageConverter

//     read

//     HttpInputMessage

		HttpInputMessage httpIntut = new HttpInputMessage() {

			@Override
			public HttpHeaders getHeaders() {
				return new HttpHeaders();
			}

			@Override
			public InputStream getBody() throws IOException {
				String oneResult = "{\"Title\":\"The Fifth Element\",\"Year\":\"1997\",\"Rated\":\"PG-13\",\"Released\":\"09 May 1997\",\"Runtime\":\"126 min\",\"Genre\":\"Action, Adventure, Sci-Fi\",\"Director\":\"Luc Besson\",\"Writer\":\"Luc Besson, Robert Mark Kamen\",\"Actors\":\"Bruce Willis, Milla Jovovich, Gary Oldman\",\"Plot\":\"In the colorful future, a cab driver unwittingly becomes the central figure in the search for a legendary cosmic weapon to keep Evil and Mr. Zorg at bay.\",\"Language\":\"English, Swedish, German, Arabic, Egyptian (Ancient)\",\"Country\":\"France, United Kingdom\",\"Awards\":\"Nominated for 1 Oscar. 10 wins & 39 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BODU4ZTE5MWYtNmY2MC00NDkyLTk0NDgtNTk5YjgzMzc4NmQwXkEyXkFqcGc@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"71%\"},{\"Source\":\"Metacritic\",\"Value\":\"52/100\"}],\"Metascore\":\"52\",\"imdbRating\":\"7.6\",\"imdbVotes\":\"515,910\",\"imdbID\":\"tt0119116\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$63,820,180\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
				return new ByteArrayInputStream(oneResult.getBytes());
			}
		};
		MappingJackson2HttpMessageConverter c = new MappingJackson2HttpMessageConverter();

		Object response = c.read(Object.class, httpIntut);
		
		System.out.println(response.getClass());
		System.out.println(response);
		
		SearchResponse searchResponse = TitleSearch200Response.getSearchResponse(response);
		Assertions.assertEquals("The Fifth Element", searchResponse.getTitle());
	}

	
	@Test
	void testMoreResult() throws HttpMessageNotReadableException, IOException {

//     MappingJackson2HttpMessageConverter

//     read

//     HttpInputMessage

		HttpInputMessage httpIntut = new HttpInputMessage() {

			@Override
			public HttpHeaders getHeaders() {
				return new HttpHeaders();
			}

			@Override
			public InputStream getBody() throws IOException {
				String moreResult = "["
						+ "{\"Title\":\"Monty Python's Life of Brian\",\"Year\":\"1979\",\"Rated\":\"R\",\"Released\":\"17 Aug 1979\",\"Runtime\":\"94 min\",\"Genre\":\"Comedy\",\"Director\":\"Terry Jones\",\"Writer\":\"Graham Chapman, John Cleese, Terry Gilliam\",\"Actors\":\"Graham Chapman, John Cleese, Michael Palin\",\"Plot\":\"Born on the original Christmas in the stable next door to Jesus Christ, Brian of Nazareth spends his life being mistaken for a messiah.\",\"Language\":\"English, Latin\",\"Country\":\"United Kingdom\",\"Awards\":\"N/A\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDMzY2E4NjEtMTJiZC00Y2UzLWFiM2MtZWVhNTg5OGQxNjk1XkEyXkFqcGc@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"77/100\"}],\"Metascore\":\"77\",\"imdbRating\":\"8.0\",\"imdbVotes\":\"424,521\",\"imdbID\":\"tt0079470\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$20,206,622\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}"
						+ ", "
						+ "{\"Title\":\"The Fifth Element\",\"Year\":\"1997\",\"Rated\":\"PG-13\",\"Released\":\"09 May 1997\",\"Runtime\":\"126 min\",\"Genre\":\"Action, Adventure, Sci-Fi\",\"Director\":\"Luc Besson\",\"Writer\":\"Luc Besson, Robert Mark Kamen\",\"Actors\":\"Bruce Willis, Milla Jovovich, Gary Oldman\",\"Plot\":\"In the colorful future, a cab driver unwittingly becomes the central figure in the search for a legendary cosmic weapon to keep Evil and Mr. Zorg at bay.\",\"Language\":\"English, Swedish, German, Arabic, Egyptian (Ancient)\",\"Country\":\"France, United Kingdom\",\"Awards\":\"Nominated for 1 Oscar. 10 wins & 39 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BODU4ZTE5MWYtNmY2MC00NDkyLTk0NDgtNTk5YjgzMzc4NmQwXkEyXkFqcGc@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"71%\"},{\"Source\":\"Metacritic\",\"Value\":\"52/100\"}],\"Metascore\":\"52\",\"imdbRating\":\"7.6\",\"imdbVotes\":\"515,910\",\"imdbID\":\"tt0119116\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$63,820,180\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}"
						+ "]";
				return new ByteArrayInputStream(moreResult.getBytes());
			}
		};
		MappingJackson2HttpMessageConverter c = new MappingJackson2HttpMessageConverter();

		Object response = c.read(Object.class, httpIntut);
		
		System.out.println(response.getClass());
		System.out.println(response);
		
		List<SearchResponse> searchResponse = TitleSearch200Response.getListSearchResponse(response);
		Assertions.assertEquals("The Fifth Element", searchResponse.get(1).getTitle());
	}
}
