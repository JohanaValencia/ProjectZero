package com.example.models;

import java.util.ArrayList;
import java.util.Random;

public class Account {

	private int accountId;
	private int accountNumber;
	private double accountBalance;
	private ArrayList<Transaction> transactions;
	private ArrayList<User> users;

	public Account() {
		transactions = new ArrayList<Transaction>();
		users= new ArrayList<User>();

	}
	
	public Account(int accountNumber) {
		this.accountNumber=accountNumber;
	}
	
	public Account(int accountNumber, double accountBalance){
		this.accountNumber = 100000000 + new Random().nextInt(900000000);
		this.accountBalance=accountBalance;
		this.transactions=new ArrayList<Transaction>();
		this.users= new ArrayList<User>();
		
	}
	
	public Account(int id, int accountNumber, double accountBalance ) {
		this.accountId=id;
		this.accountNumber=accountNumber;
		this.accountBalance=accountBalance;
		this.transactions=new ArrayList<Transaction>();
		this.users= new ArrayList<User>();
		
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + ", transactions=" + transactions + ", users=" + users + "]";
	}
	
		
}