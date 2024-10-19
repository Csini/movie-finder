# SearchParameterApi

All URIs are relative to *http://omdbapi.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**titleSearch**](SearchParameterApi.md#titleSearch) | **GET** / | Returns an array of results for a given title |



## titleSearch

> TitleSearch200Response titleSearch(s, y, type, r, page, paramCallback)

Returns an array of results for a given title

### Example

```java
// Import classes:
import com.omdbapi.openapi.client.ApiClient;
import com.omdbapi.openapi.client.ApiException;
import com.omdbapi.openapi.client.Configuration;
import com.omdbapi.openapi.client.auth.*;
import com.omdbapi.openapi.client.models.*;
import com.omdbapi.openapi.client.api.SearchParameterApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://omdbapi.com");
        
        // Configure API key authorization: ApiKeyAuth
        ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        ApiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKeyAuth.setApiKeyPrefix("Token");

        SearchParameterApi apiInstance = new SearchParameterApi(defaultClient);
        String s = "s_example"; // String | Title of movie or series
        Integer y = 56; // Integer | Year of release
        String type = "movie"; // String | Return movie or series
        String r = "json"; // String | The response type to return
        Integer page = 56; // Integer | Page number to return
        String paramCallback = "paramCallback_example"; // String | JSONP callback name
        try {
            TitleSearch200Response result = apiInstance.titleSearch(s, y, type, r, page, paramCallback);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SearchParameterApi#titleSearch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **s** | **String**| Title of movie or series | |
| **y** | **Integer**| Year of release | [optional] |
| **type** | **String**| Return movie or series | [optional] [enum: movie, series] |
| **r** | **String**| The response type to return | [optional] [enum: json, xml] |
| **page** | **Integer**| Page number to return | [optional] |
| **paramCallback** | **String**| JSONP callback name | [optional] |

### Return type

[**TitleSearch200Response**](TitleSearch200Response.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** | Not authenticated |  -  |

