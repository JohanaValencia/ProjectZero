package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private List<Account> accounts; 
	
	public Customer() {
		accounts = new ArrayList<Account>();
	}
	//Theoratically may not be needed
	public Customer(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.username= firstName+ lastName+ (new Random().nextInt(9000)+1000);
		this.email=email;
		this.password=password;
		this.accounts= new ArrayList<Account>();		
	}
	//Used to send user info to the database because the db auto generates the id
	public Customer(String firstName, String lastName, String email, String password) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.username= firstName+ lastName+ (new Random().nextInt(9000)+1000);
		this.email=email;
		this.password=password;
		this.accounts= new ArrayList<Account>();		
	}
	
	//User to get info from the database
	public Customer(int id, String firstName, String lastName,String username,  String email, String password) {
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.username= username;
		this.email=email;
		this.password=password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", accounts=" + accounts + "]";
	}

	
}
