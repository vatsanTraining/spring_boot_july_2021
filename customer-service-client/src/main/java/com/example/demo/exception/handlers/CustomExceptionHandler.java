package com.example.demo.exception.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class CustomExceptionHandler {

	
	        @ExceptionHandler(value=WebClientResponseException.class)
			public ResponseEntity<ErrorMessage> handleWebClientResponseException(
			      WebClientResponseException ex) {
	        	
	        	  ErrorMessage msg = new ErrorMessage(ex.getResponseBodyAsString(),"User is not authorized to access the page");
	        	  
			        return ResponseEntity.status(ex.getRawStatusCode())
			  .body(msg);
			}

}
