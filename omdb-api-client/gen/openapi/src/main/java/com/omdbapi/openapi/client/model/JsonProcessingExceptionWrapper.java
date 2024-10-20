package com.omdbapi.openapi.client.model;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonProcessingExceptionWrapper extends RuntimeException {

	private JsonProcessingException exceptionOrig;

	public JsonProcessingExceptionWrapper(JsonProcessingException cause) {
		super(cause);
		this.exceptionOrig = cause;
	}

	public JsonProcessingException getExceptionOrig() {
		return exceptionOrig;
	}

}
