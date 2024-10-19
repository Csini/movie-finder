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
@JsonPropertyOrder({
  TitleSearch200Response.JSON_PROPERTY_TITLE,
  TitleSearch200Response.JSON_PROPERTY_YEAR,
  TitleSearch200Response.JSON_PROPERTY_DIRECTOR,
  TitleSearch200Response.JSON_PROPERTY_RESPONSE
})
@JsonTypeName("titleSearch_200_response")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-19T19:24:39.590534200+02:00[Europe/Budapest]", comments = "Generator version: 7.9.0")
public class TitleSearch200Response implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TITLE = "Title";
  private String title;

  public static final String JSON_PROPERTY_YEAR = "Year";
  private String year;

  public static final String JSON_PROPERTY_DIRECTOR = "Director";
  private String director;

  public static final String JSON_PROPERTY_RESPONSE = "Response";
  private Boolean response;

  public TitleSearch200Response() {
  }

  public TitleSearch200Response title(String title) {
    
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @jakarta.annotation.Nonnull
  @NotNull

  @Schema(example = "Countdown", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTitle() {
    return title;
  }


  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTitle(String title) {
    this.title = title;
  }

  public TitleSearch200Response year(String year) {
    
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   */
  @jakarta.annotation.Nonnull
  @NotNull

  @Schema(example = "1967", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
  @JsonProperty(JSON_PROPERTY_YEAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getYear() {
    return year;
  }


  @JsonProperty(JSON_PROPERTY_YEAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setYear(String year) {
    this.year = year;
  }

  public TitleSearch200Response director(String director) {
    
    this.director = director;
    return this;
  }

  /**
   * Get director
   * @return director
   */
  @jakarta.annotation.Nonnull
  @NotNull

  @Schema(example = "John Doe", requiredMode = Schema.RequiredMode.REQUIRED, description = "")
  @JsonProperty(JSON_PROPERTY_DIRECTOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDirector() {
    return director;
  }


  @JsonProperty(JSON_PROPERTY_DIRECTOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDirector(String director) {
    this.director = director;
  }

  public TitleSearch200Response response(Boolean response) {
    
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
   */
  @jakarta.annotation.Nullable

  @Schema(example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "")
  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getResponse() {
    return response;
  }


  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResponse(Boolean response) {
    this.response = response;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TitleSearch200Response titleSearch200Response = (TitleSearch200Response) o;
    return Objects.equals(this.title, titleSearch200Response.title) &&
        Objects.equals(this.year, titleSearch200Response.year) &&
        Objects.equals(this.director, titleSearch200Response.director) &&
        Objects.equals(this.response, titleSearch200Response.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, year, director, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TitleSearch200Response {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    director: ").append(toIndentedString(director)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

