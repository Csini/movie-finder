package hu.exercise.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableJpaRepositories
//@EnableTransactionManagement
@ComponentScan
public class MovieBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBusinessApplication.class, args);
	}

}
