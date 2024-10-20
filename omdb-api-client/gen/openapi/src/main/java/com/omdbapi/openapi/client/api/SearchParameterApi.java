package com.omdbapi.openapi.client.api;

import com.omdbapi.openapi.client.ApiClient;
import com.omdbapi.openapi.client.BaseApi;

import com.omdbapi.openapi.client.model.TitleSearch200Response;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-19T19:24:39.590534200+02:00[Europe/Budapest]", comments = "Generator version: 7.9.0")
@Component("com.omdbapi.openapi.client.api.SearchParameterApi")
public class SearchParameterApi extends BaseApi {

    public SearchParameterApi() {
        super(new ApiClient());
    }

    @Autowired
    public SearchParameterApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Returns an array of results for a given title
     * 
     * <p><b>200</b> - 
     * <p><b>401</b> - Not authenticated
     * @param s Title of movie or series (required)
     * @param y Year of release (optional)
     * @param type Return movie or series (optional)
     * @param r The response type to return (optional)
     * @param page Page number to return (optional)
     * @param paramCallback JSONP callback name (optional)
     * @return TitleSearch200Response
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object titleSearch(String s, Integer y, String type, String r, Integer page, String paramCallback) throws RestClientException {
        return titleSearchWithHttpInfo(s, y, type, r, page, paramCallback).getBody();
    }

    /**
     * Returns an array of results for a given title
     * 
     * <p><b>200</b> - 
     * <p><b>401</b> - Not authenticated
     * @param s Title of movie or series (required)
     * @param y Year of release (optional)
     * @param type Return movie or series (optional)
     * @param r The response type to return (optional)
     * @param page Page number to return (optional)
     * @param paramCallback JSONP callback name (optional)
     * @return ResponseEntity&lt;TitleSearch200Response&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> titleSearchWithHttpInfo(String s, Integer y, String type, String r, Integer page, String paramCallback) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 's' is set
        if (s == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 's' when calling titleSearch");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "s", s));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "y", y));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "r", r));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "callback", paramCallback));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };

        ParameterizedTypeReference<Object> localReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "ApiKeyAuth" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
