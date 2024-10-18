package hu.exercise.movie.config;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionResponse {
    private HttpStatus statusCode;
    private String message;
}
