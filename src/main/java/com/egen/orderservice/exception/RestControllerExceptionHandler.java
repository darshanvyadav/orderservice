package com.egen.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestControllerExceptionHandler {
	
	
	@ExceptionHandler
	public String handleRuntimeException(Exception exception) {
		return  "Error Code : " + HttpStatus.INTERNAL_SERVER_ERROR + " Message : "+exception.getMessage() ;
	}
	
	@ExceptionHandler
	public String handleRuntimeException(OrderNotFoundException exception,WebRequest webrequest) {
		return exception.getMessage();
	}
	
	@ExceptionHandler
	public String badRequest(MethodArgumentNotValidException excption) {
		return  "Error Code : " + HttpStatus.BAD_REQUEST + " Message : "+ excption.getMessage() ;
	}	
	
	// need to implement more custom exception to cover all type of exception 
	

}
