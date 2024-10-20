package hu.exercise.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = { "hu.exercise.movie", "com.omdbapi.openapi.client",
		"org.themoviedb.openapi.client" })
@EnableCaching
public class MovieBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBusinessApplication.class, args);
	}

}
