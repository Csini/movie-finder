package hu.exercise.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI MoviesMicroserviceOpenAPI() {
		return new OpenAPI().info(new Info().description("Movie Finder Service").title("Movie Finder API")
				.version(OpenAPIConfig.class.getPackage().getImplementationVersion()));
	}
}