package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.models.Employee;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class EmployeeDaoDB implements EmployeeDao {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public Employee getEmployeeByEID(int id) {
		Employee employee = new Employee();
		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM employees WHERE employees.emp_number=" + id;
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setEmpLastName(rs.getString(3));
				employee.setEmpNumber(rs.getInt(4));
				employee.setEmpPassword(rs.getString(5));

			}
			return employee;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createEmployee(Employee em) throws SQLException {
		
		Connection con = conUtil.getConnection();
		String sql = "INSERT INTO employees(emp_name, emp_last_name, emp_number,emp_password) values"
				+ "(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);	
		
		ps.setString(1, em.getEmpName());
		ps.setString(2, em.getEmpLastName());
		ps.setInt(3, em.getEmpNumber());
		ps.setString(4, em.getEmpPassword());
	}

	@Override
	public void updateEmployee(Employee em) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE employess SET emp_name = ?, emp_last_name = ?, emp_number = ?,emp_password = ?"
					+ " WHERE employees.emp_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, em.getEmpName());
			ps.setString(2, em.getEmpLastName());
			ps.setInt(3, em.getEmpNumber());
			ps.setString(4, em.getEmpPassword());
			ps.setInt(5, em.getEmpId());
			
			ps.execute();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(Employee em) {

	try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM employees WHERE employees.emp_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, em.getEmpId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			Connection con = conUtil.getConnection();		
			String sql = "SELECT * FROM employees";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
				
			}
		return employeeList;
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User u) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, username = ?, password = ? "
					+ " WHERE users.id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getUsername());
			ps.setString(5, u.getPassword());
			ps.setInt(6, u.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(User u) {
		
		try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM users WHERE users.id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, u.getId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Account getAccountByAccountNumber(int accountNumber) {
		Account account = new Account();
		try {
			Connection con = conUtil.getConnection();
			
			String sql ="SELECT * FROM accounts WHERE accounts.account_number= " + accountNumber;
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setCustomerId(rs.getInt(2));
				account.setAccountNumber(rs.getInt(3));
				account.setAccountBalance(rs.getDouble(4));
			}
			return account;
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
