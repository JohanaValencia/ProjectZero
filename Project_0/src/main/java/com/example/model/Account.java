package com.example.model;

import java.util.ArrayList;
import java.util.Random;

public class Account {

	private int accountId;
	private int accountNumber;
	private int accountBalance;
	private ArrayList<Transaction> transactions;

	public Account() {
		transactions = new ArrayList<Transaction>();

	}

	public Account(int accountId, int accountBalance) {
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.accountNumber = 100000000 + new Random().nextInt(900000000);
		this.transactions = new ArrayList<Transaction>();

	}

	public Account(int accountBalance) {
		this.accountBalance = accountBalance;
		this.accountNumber = 100000000 + new Random().nextInt(900000000);
		this.transactions = new ArrayList<Transaction>();
	}

	public Account(int accountId, int accountBalance, int accountNumber) {
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.accountNumber=accountNumber;
		this.transactions= new ArrayList<Transaction>();
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

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
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
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + ", transactions=" + transactions + "]";
	}
	
}