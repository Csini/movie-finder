package com.omdbapi.openapi.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * TitleSearch200Response - manually edited, because there is a BUG in openapi generator with oneOf
 * @author Csini
 */
@JsonTypeName("titleSearch_200_response")
public class TitleSearch200Response implements Serializable {
	private static JsonMapper objectMapper = new JsonMapper();

	static {
//		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper = JsonMapper.builder().configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION, true)
				.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true).build();
	}
	
	protected TitleSearch200Response() {
		super();
	}

	/**
	 * Get the actual instance of `SearchResponse`. If the actual instance is not
	 * `SearchResponse`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `SearchResponse`
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	public static SearchResponse getSearchResponse(Object response)
			throws JsonMappingException, JsonProcessingException {

		LinkedHashMap<Object, Object> bla = (LinkedHashMap<Object, Object>) response;

//		MappingJackson2HttpMessageConverter c = new MappingJackson2HttpMessageConverter();
//		return c.read(SearchResponse.class, httpInput);
		Assertions.assertTrue(objectMapper.canSerialize(SearchResponse.class));

		return mapSearchResponse(response);
	}

	private static SearchResponse mapSearchResponse(Object linkedHashMap)
			throws JsonProcessingException, JsonMappingException {

		LinkedHashMap<Object, Object> bla = (LinkedHashMap<Object, Object>) linkedHashMap;

		LinkedHashMap<Object, Object> filteredLinkedHashMap = new LinkedHashMap<Object, Object>();

		filteredLinkedHashMap.put("Title", bla.get("Title"));
		filteredLinkedHashMap.put("Year", bla.get("Year"));
		filteredLinkedHashMap.put("Director", bla.get("Director"));

		String writeValueAsString = objectMapper.writeValueAsString(filteredLinkedHashMap);
		System.out.println(writeValueAsString);
		return objectMapper.readValue(writeValueAsString, SearchResponse.class);
	}

	/**
	 * Get the actual instance of `List<SearchResponse>`. If the actual instance is
	 * not `List<SearchResponse>`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `List<SearchResponse>`
	 * @throws ClassCastException      if the instance is not `List<SearchResponse>`
	 * @throws JsonProcessingException
	 */
	public static List<SearchResponse> getListSearchResponse(Object response)
			throws ClassCastException, JsonProcessingException {

		// test the class
		List<Object> bla = (List<Object>) response;

		String writeValueAsString = objectMapper.writeValueAsString(response);

		List<LinkedHashMap<Object, Object>> list = objectMapper.readValue(writeValueAsString, List.class);
		try {
			return list.stream().map(linkedHashMap -> {
				try {
					return mapSearchResponse(linkedHashMap);
				} catch (JsonProcessingException e) {
					throw new JsonProcessingExceptionWrapper(e);
				}
			}).filter(element -> element != null).collect(Collectors.toList());
		} catch (JsonProcessingExceptionWrapper we) {
			throw we.getExceptionOrig();
		}
	}
}
