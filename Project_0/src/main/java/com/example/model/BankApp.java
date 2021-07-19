package com.example.model;

import java.math.BigInteger;
import java.util.UUID;

public class BankApp {

	private static  String newAccountNumber;
	private static  String existingAccountNumber;
	
	
	public BankApp() {
		super();
	}
	
	public BankApp(String newAccountNumber, String existingAccountNumber) {
		super();
		this.newAccountNumber = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		this.existingAccountNumber = existingAccountNumber;
	}


	public static String getExistingAccountNumber() {
		return existingAccountNumber;
	}

	public static void setExistingAccountNumber(String existingAccountNumber) {
		BankApp.existingAccountNumber = existingAccountNumber;
	}

	public static String getNewAccountNumber() {
		return newAccountNumber;
	}


	public void setNewAccountNumber(String newAccountNumber) {
		this.newAccountNumber = newAccountNumber;
	}


}
