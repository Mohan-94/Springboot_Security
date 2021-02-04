package com.app.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomErrorAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(GenricException.class)
	public final ResponseEntity<Object> handleAllExceptions(GenricException ex, final HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse(ex.getStatus(), ex.getMessage(), request.getRequestURL().toString());
		return new ResponseEntity<>(error, ex.getStatus());
	}
}
