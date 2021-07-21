package com.example.exceptions;

public class InvalidAccountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidAccountException() {
		super("User Provided Invalid Account");
	}

}
