package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Account;
import com.example.models.Employee;
import com.example.models.User;

public interface EmployeeDao {

	Employee getEmployeeByEID(int id );
	
	void createEmployee(Employee em) throws SQLException;
	
	void updateEmployee(Employee em);
	
	void deleteEmployee(Employee em);
	
	List<Employee> getAllEmployees();
	
	void updateUser(User u);
	
	void deleteUser(User u);
	
	public Account getAccountByAccountNumber(int accountNumber);
	
}
