package com.example.model;

public class AccountDisplay {

	private String firstName;
	private int accountId;
	private int accountNumber;
	private int accountBalance;
	
	public AccountDisplay() {
		super();
	}
	
	public AccountDisplay(String firstName, int accountId, int accountNumber,  int accountBalance) {
		super();
		this.firstName = firstName;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	@Override
	public String toString() {
		return "AccountDisplay [firstName=" + firstName + ", accountId=" + accountId + ", accountNumber="
				+ accountNumber + ", accountBalance=" + accountBalance + "]";
	}
	
}
