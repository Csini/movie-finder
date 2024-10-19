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

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.omdbapi.openapi.client.model.SearchResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.*;

/**
 * TitleSearch200Response
 */
@JsonTypeName("titleSearch_200_response")
public class TitleSearch200Response implements Serializable {
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
