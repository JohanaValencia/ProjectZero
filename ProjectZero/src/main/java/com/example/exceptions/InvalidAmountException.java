package com.example.exceptions;

public class InvalidAmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidAmountException() {
		super("User Provided Invalid Amount");
	}

}