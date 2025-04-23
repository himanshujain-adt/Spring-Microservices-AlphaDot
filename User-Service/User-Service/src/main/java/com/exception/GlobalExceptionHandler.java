package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {

		String message = exception.getMessage();
		APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
	}

}
