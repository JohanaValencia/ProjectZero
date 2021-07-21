package com.example.exceptions;

public class InvalidEmployeeCredentialsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidEmployeeCredentialsException() {
		super("Employee Provided Invalid Credentials");
	}
}