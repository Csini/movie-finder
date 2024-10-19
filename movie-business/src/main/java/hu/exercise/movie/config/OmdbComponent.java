package hu.exercise.movie.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.omdbapi.openapi.client.ApiClient;

@Component
public class OmdbComponent implements InitializingBean {
	
	@Value(value = "${apikey.omdb}")
	String apiKeyOmdb;

	@Autowired
	ApiClient apiClient;

	@Override
	public void afterPropertiesSet() throws Exception {
		apiClient.setApiKey(apiKeyOmdb);
//		apiClient.setBasePath();
	}

}
