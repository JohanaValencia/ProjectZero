package com.example.exceptions;

public class CustomerDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CustomerDoesNotExistException() {
		super("User tried logging in with credentials that don't exist");
	}
	
}