package com.example.models;

import java.util.ArrayList;
import java.util.Random;

public class Account {

	private int accountId;
	private int customerId;
	private int accountNumber;
	private double accountBalance;
	private ArrayList<Transaction> transactions;

	public Account() {
		transactions = new ArrayList<Transaction>();

	}
	
	
	public Account(double accountBalance) {
		this.accountBalance=accountBalance;
	}
	
	public Account (int customerId) {
		this.customerId=customerId;
	}
	
	public Account(int id, int customerId,double accountBalance) {
		super();
		this.accountId=id;
		this.customerId=customerId;
		this.accountNumber = 100000000 + new Random().nextInt(900000000);
		this.accountBalance=accountBalance;
		this.transactions=new ArrayList<Transaction>();

	}
	
	//Used to send info to database because data base auto generates the id
	public Account(int customerId, double accountBalance){
		super();
		this.customerId=customerId;
		this.accountNumber = 100000000 + new Random().nextInt(900000000);
		this.accountBalance=accountBalance;
		this.transactions=new ArrayList<Transaction>();
		
	}
	
	// User to get info from the database
	public Account(int id, int customerId, int accountNumber, double accountBalance) {
		super();
		this.accountId=id;
		this.customerId=customerId;
		this.accountNumber=accountNumber;
		this.accountBalance=accountBalance;
		this.transactions=new ArrayList<Transaction>();
		
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", accountBalance=" + accountBalance + "]";
	}
		
}