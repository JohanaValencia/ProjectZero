package com.example.models;
import java.util.ArrayList;
import java.util.Random;


public class Employee {
	private int empId;
	private String empName;
	private String empLastName;
	private int empNumber;
	private String empPassword;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	private ArrayList<Employee> employees;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empId,String empName, String empLastName, String empPassword ) {
		super();
		this.empName = empName;
		this.empLastName = empLastName;
		this.empPassword = empPassword;
		this.empNumber = new Random().nextInt(9000000)+1000000;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		this.employees= new ArrayList<Employee>();
	}
	

	public Employee(String empName, String empLastName, String empPassword ) {
		super();
		this.empName = empName;
		this.empLastName = empLastName;
		this.empPassword = empPassword;
		this.empNumber = new Random().nextInt(9000000)+1000000;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		this.employees= new ArrayList<Employee>();
	}
	
	public Employee(int empId,String empName, String empLastName,int empNumber, String empPassword ) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empLastName = empLastName;
		this.empPassword = empPassword;
		this.empNumber = empNumber;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		this.employees= new ArrayList<Employee>();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empLastName=" + empLastName + ", empNumber="
				+ empNumber + ", empPassword=" + empPassword + ", users=" + users + ", accounts=" + accounts
				+ ", employees=" + employees + "]";
	}

	
	
}