package com.example.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmployeeDoesNotExistException() {
		super("Employee tried logging in with credentials that don't exist");
	}
	
}