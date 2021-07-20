package com.example.model;

public class Transaction {

	private int transId;
	private int accountSen;
	private int accountRec;	
	private double balanceSen;
	private double balanceRec;
	private double transactionAmount;
	
	
	public Transaction() {
		
	}
	
	public Transaction(int id, int accountSen, int accountRec, double balanceSen, double balanceRec, double transactionAmount) {
		this.transId = id;
		this.accountSen = accountSen;
		this.accountRec = accountRec;
		this.balanceSen = balanceSen;
		this.balanceRec = balanceRec;
		this.transactionAmount = transactionAmount;
	}
	
	public Transaction(int accountSen, int accountRec, double balanceSen, double balanceRec, double transactionAmount) {
		this.accountSen = accountSen;
		this.accountRec = accountRec;
		this.balanceSen = balanceSen;
		this.balanceRec = balanceRec;
		this.transactionAmount = transactionAmount;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getAccountSen() {
		return accountSen;
	}

	public void setAccountSen(int accountSen) {
		this.accountSen = accountSen;
	}

	public int getAccountRec() {
		return accountRec;
	}

	public void setAccountRec(int accountRec) {
		this.accountRec = accountRec;
	}

	public double getBalanceSen() {
		return balanceSen;
	}

	public void setBalanceSen(double balanceSen) {
		this.balanceSen = balanceSen;
	}

	public double getBalanceRec() {
		return balanceRec;
	}

	public void setBalanceRec(double balanceRec) {
		this.balanceRec = balanceRec;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", accountSen=" + accountSen + ", accountRec=" + accountRec
				+ ", balanceSen=" + balanceSen + ", balanceRec=" + balanceRec + ", transactionAmount="
				+ transactionAmount + "]";
	}
	
	
}
