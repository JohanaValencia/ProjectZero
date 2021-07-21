package com.example.models;

public class Transaction {

	private double transactionAmount;
	private String message;

	private Account depAccount;

	private void Transaction() {

	}

	public Transaction(double transactionAmount, Account depAccount) {
		this.transactionAmount = transactionAmount;
		this.depAccount = depAccount;
		this.message = " ";

	}

	public Transaction(double transactionAmount, String message, Account depAccount) {

		this(transactionAmount,depAccount);
		this.message=message;
		
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Account getDepAccount() {
		return depAccount;
	}

	public void setDepAccount(Account depAccount) {
		this.depAccount = depAccount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionAmount=" + transactionAmount + ", message=" + message + ", depAccount="
				+ depAccount + "]";
	}
	
}