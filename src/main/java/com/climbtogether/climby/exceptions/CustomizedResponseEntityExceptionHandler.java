package com.climbtogether.climby.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { UserNotFoundException.class, ReservationNotFoundException.class,TravelNotFoundException.class })
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(WebRequest request) {

			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"Not found",
					request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
			return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	
		
	
	}

}