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


package com.omdbapi.openapi.client.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-19T19:24:39.590534200+02:00[Europe/Budapest]", comments = "Generator version: 7.9.0")
public class ApiKeyAuth implements Authentication {
    private final String location;
    private final String paramName;

    private String apiKey;
    private String apiKeyPrefix;

    public ApiKeyAuth(String location, String paramName) {
        this.location = location;
        this.paramName = paramName;
    }

    public String getLocation() {
        return location;
    }

    public String getParamName() {
        return paramName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKeyPrefix() {
        return apiKeyPrefix;
    }

    public void setApiKeyPrefix(String apiKeyPrefix) {
        this.apiKeyPrefix = apiKeyPrefix;
    }

    @Override
    public void applyToParams(MultiValueMap<String, String> queryParams, HttpHeaders headerParams, MultiValueMap<String, String> cookieParams) {
        if (apiKey == null) {
            return;
        }
        String value;
        if (apiKeyPrefix != null) {
            value = apiKeyPrefix + " " + apiKey;
        } else {
            value = apiKey;
        }
        if (location.equals("query")) {
            queryParams.add(paramName, value);
        } else if (location.equals("header")) {
            headerParams.add(paramName, value);
        } else if (location.equals("cookie")) {
            cookieParams.add(paramName, value);
        }
    }
}
