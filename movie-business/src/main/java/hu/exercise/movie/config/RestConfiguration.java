package hu.exercise.movie.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();

//	       RestTemplate restTemplate = new RestTemplate();
//	        // This allows us to read the response more than once - Necessary for debugging.
//	        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
//
//	        // disable default URL encoding
//	        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
//	        uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
//	        restTemplate.setUriTemplateHandler(uriBuilderFactory);
//	        return restTemplate;
	}
}
