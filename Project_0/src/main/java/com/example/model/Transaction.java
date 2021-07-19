package com.example.model;

public class Transaction {

	private int transId;
	private int accountId;
	private String accountNumber;	
	private double postBalance;
	
	
	public Transaction() {
		
	}
	
	public Transaction(int id, int accountId, String accountNumber, double balance) {
		this.transId=id;
		this.accountId=accountId;
		this.accountNumber=accountNumber;
		this.postBalance= balance;
	}
	
	public Transaction (int accountId, String accountNumber, double balance) {
		this.accountId=accountId;
		this.accountNumber=accountNumber;
		this.postBalance= balance;
	}
	
	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getPostBalance() {
		return postBalance;
	}

	public void setPostBalance(double postBalance) {
		this.postBalance = postBalance;
	}

	public void deposit(double amount) {
		postBalance = postBalance + amount;
	}
	
	public void withdraw(double amount) {
		postBalance = postBalance - amount;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", accountId=" + accountId + ", accountNumber=" + accountNumber
				+ ", postBalance=" + postBalance + "]";
	}
	
	
	
}
