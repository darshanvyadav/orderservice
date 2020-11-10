package com.egen.orderservice.exception;

public class OrderCreateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderCreateException(String message) {
		super(message);
	}

}
