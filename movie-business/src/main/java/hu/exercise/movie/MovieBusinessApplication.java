package hu.exercise.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"hu.exercise.movie", "com.omdbapi.openapi.client", "org.themoviedb.openapi.client"})
//@EnableJpaRepositories
//@EnableTransactionManagement
//@ComponentScan
public class MovieBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBusinessApplication.class, args);
	}

}
