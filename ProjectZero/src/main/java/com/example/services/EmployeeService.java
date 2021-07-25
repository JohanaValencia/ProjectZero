package com.example.services;

import java.sql.SQLException;

import com.example.dao.EmployeeDao;
import com.example.exceptions.EmployeeAlreadyExistsException;
import com.example.exceptions.EmployeeDoesNotExistException;
import com.example.exceptions.InvalidAccountException;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.InvalidEmployeeCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.Employee;
import com.example.models.User;

public class EmployeeService {

	
	/*private Employee eDao;
	
	public EmployeeService(EmployeeDao em) {
		this.eDao=em;
	}
	public Employee createEmployee(String firstname, String lastname, String password) throws EmployeeAlreadyExistsException{
		Employee em = new Employee(firstname, lastname, password);
		
		try {
			eDao.createEmployee(em);
			Logging.logger.info("New employee has registered");

		}catch(SQLException e) {
			Logging.logger.warn("Employee number already exists in the database");
			throw new EmployeeAlreadyExistsException();

		}
	}
	
	public Employee signIn(int id, String password) throws EmployeeDoesNotExistException, InvalidEmployeeCredentialsException{
		Employee em = eDao.getEmployeeByEID(id);
		
		if(em.getEmpId() == 0) {
			Logging.logger.warn("User tried loggging in that does not exist");
			throw new EmployeeDoesNotExistException();
		}else if(em.getEmpNumber() != id) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidEmployeeCredentialsException();
		}else {
			Logging.logger.info("User was logged in");
			return em;
		}
	}*/
}
