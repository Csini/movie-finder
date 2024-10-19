/*
 * OMDb API
 * This API requires authorization, you can get a free key here: [http://omdbapi.com/apikey.aspx](http://omdbapi.com/apikey.aspx)
 *
 * The version of the OpenAPI document: 1.0
 * Contact: bfritz@fadingsignal.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.omdbapi.openapi.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * TitleSearch200Response
 */
@JsonTypeName("titleSearch_200_response")
public class TitleSearch200Response extends ArrayList<SearchResponse> implements Serializable {
	/**
	 * Get the actual instance of `SearchResponse`. If the actual instance is not
	 * `SearchResponse`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `SearchResponse`
	 * @throws ClassCastException if the instance is not `SearchResponse`
	 */
	public SearchResponse getSearchResponse() throws ClassCastException {
		return (SearchResponse) this;
	}

	/**
	 * Get the actual instance of `List<SearchResponse>`. If the actual instance is
	 * not `List<SearchResponse>`, the ClassCastException will be thrown.
	 *
	 * @return The actual instance of `List<SearchResponse>`
	 * @throws ClassCastException if the instance is not `List<SearchResponse>`
	 */
	public List<SearchResponse> getListSearchResponse() throws ClassCastException {
		return (List<SearchResponse>) this;
	}
}
