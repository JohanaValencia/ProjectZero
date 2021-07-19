package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String eUsername;
	private String ePassword;
	private List<Account> accounts; 
	
	
	public Employee() {
		
	}

	public Employee(int id, String firstName, String lastName, String password) {
		this.id= id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eUsername = firstName+ lastName+ (new Random().nextInt(9000)+1000);
		this.ePassword = password;
	}
	
	//used to send employee info to database because 
	public Employee( String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.eUsername = firstName+ lastName+ (new Random().nextInt(9000)+1000);
		this.ePassword = password;
		this.accounts= new ArrayList<Account>();
	}
	
	public Employee(int id, String firstName, String lastName,String username, String password) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.eUsername= username;
		this.ePassword=password;
		this.accounts= new ArrayList<Account>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteUsername() {
		return eUsername;
	}

	public void seteUsername(String eUsername) {
		this.eUsername = eUsername;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", eUsername=" + eUsername
				+ ", ePassword=" + ePassword + ", accounts=" + accounts + "]";
	}
	
	
	
}
