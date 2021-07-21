package com.example.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmployeeAlreadyExistsException() {
		super("An employee with this employee number already exists in the database");
	}

}
