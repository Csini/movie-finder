package hu.exercise.movie.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandler extends ResponseStatusExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);
	public static final String ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM = "A request feldolgozása során hiba történt, kérjük vegye fel a kapcsolatot az Application teammel.";

	@org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
	public static final ResponseEntity<ExceptionResponse> exceptionHandler(EntityNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM);
		exceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST);
		logError(ex, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
	public static final ResponseEntity<ExceptionResponse> exceptionHandler(IllegalArgumentException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM);
		exceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST);
		logError(ex, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
	public static final ResponseEntity<ExceptionResponse> exceptionHandler(RuntimeException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM);
		exceptionResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		logError(ex, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.web.client.HttpClientErrorException.class)
//	public static final ResponseEntity<ExceptionResponse> exceptionHandler(
//			org.springframework.web.client.HttpClientErrorException ex) {
//		ExceptionResponse exceptionResponse = new ExceptionResponse();
//		exceptionResponse.setMessage(ex.getMessage());
//		exceptionResponse.setStatusCode(HttpStatus.valueOf(ex.getStatusCode().value()));
//		logError(ex, ex.getStatusCode());
//		return new ResponseEntity<>(exceptionResponse, ex.getStatusCode());
//	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public static final ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM);
		exceptionResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		logError(ex, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static void logError(Exception exception, HttpStatusCode statusCode) {
		log.error("Exception Cause Message : {}", exception);
		log.error("Returned Status: {}", statusCode.value());
	}
}
