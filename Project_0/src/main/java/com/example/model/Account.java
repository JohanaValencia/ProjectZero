package com.example.model;

import java.util.ArrayList;
import java.util.Random;

public class Account {

	private int accountId;
	private int authorId;
	private int externalId;
	private int accountNumber;
	private ArrayList<Transaction> transactions;

	public Account() {
		transactions = new ArrayList<Transaction>();

	}

	public Account(int accountId, int authorId, int externalId) {
		this.accountId = accountId;
		this.authorId = authorId;
		this.externalId = externalId;
		this.accountNumber = 100000000 + new Random().nextInt(900000000);
		this.transactions = new ArrayList<Transaction>();

	}

	public Account(int authorId, int externalId) {
		this.authorId = authorId;
		this.externalId = externalId;
		this.accountNumber = 100000000 + new Random().nextInt(900000000);
		this.transactions = new ArrayList<Transaction>();
	}

	public Account(int accountId, int authorId, int externalId, int accountNumber) {
		this.accountId = accountId;
		this.authorId = authorId;
		this.externalId = externalId;
		this.accountNumber=accountNumber;
		this.transactions= new ArrayList<Transaction>();
	}




	
	
}