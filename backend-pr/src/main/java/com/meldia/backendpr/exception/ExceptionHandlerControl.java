package com.meldia.backendpr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerControl {
	
	@ExceptionHandler(ResourceException.class)
	public ResponseEntity<ErrorMessages> resourceNotFoundException(ResourceException ex, WebRequest req) {
		
		ErrorMessages msg = new ErrorMessages(
				
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				req.getDescription(false)
				
				);
		return new ResponseEntity<ErrorMessages>(msg, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessages> globalException(Exception ex, WebRequest req) {
		
		ErrorMessages msg = new ErrorMessages(
				
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(),
				req.getDescription(false)
				
				);
		return new ResponseEntity<ErrorMessages>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
