
package com.example.services;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.exceptions.AccountAlreadyExistsException;
import com.example.exceptions.InvalidAccountException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.User;

public class AccountService {

	private AccountDao aDao;
	
	public AccountService(AccountDao a) {
		this.aDao = a;
	}
	
	public Account createAccount(int customerId, double accountBalance) {
		Account a = new Account(customerId, accountBalance);
		try {
			aDao.createAccount(a);
			Logging.logger.info("You have successfully opened a new account");
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AccountAlreadyExistsException();
		}
		return a;
	}
	
	public Account viewAccountByAccountNum(int accountNumber) {
		Account a = aDao.getAccountByAccountNumber(accountNumber);
		if(a.getAccountId() == 0) {
			Logging.logger.warn("User tried to view an account that does not exist or is closed");
			throw new InvalidAccountException();
		}
		else if(a.getAccountNumber() != accountNumber) {
			Logging.logger.warn("User tried to view account with invalid account");
		}
		else {
			Logging.logger.info("Account was viewed");
		}
		return a;
		
	}
	
	public Account getAccountByCustomerId(int customerId) {
		Account a = aDao.getAccountByCustomerId(customerId);
		if(a.getCustomerId() == 0) {
			Logging.logger.warn("User tried to create an account that does not exist or is closed");
			throw new InvalidAccountException();
		}
		else if(a.getAccountNumber() != customerId) {
			Logging.logger.warn("User tried to create account with invalid customer Id");
		}
		else {
			Logging.logger.info("Account was created successfully");
		}
		return a;
	}
	
	public Account deleteAccount(int accountNumber) {
		Account a = aDao.getAccountByAccountNumber(accountNumber);
		if(a.getAccountNumber()== accountNumber) {
			Account delete = new Account(accountNumber);
			aDao.deleteAccount(delete);
			System.out.println("Your account has been deactivated. Good Bye");
		}else {
			System.out.println("Invalid account number was provided");
		}
		return a;
	
		}
	
	public Account updateAccount(int accountNumber , double accountBalance) {
		Account a= aDao.getAccountByAccountNumber(accountNumber);
		if(a.getAccountNumber()== accountNumber) {
			Account updateAccountNumber = new Account(accountNumber);
			aDao.updateAccount(updateAccountNumber);
			System.out.println("You have successfully updated your account number to "+ updateAccountNumber);
		}else if(a.getAccountNumber() == accountNumber) {
			Account updateAccountBalance = new Account(accountBalance);
			aDao.updateAccount(updateAccountBalance);
		}
		else {
			System.out.println("Invalid account number was provided");
		}
		return a;
		}

	
	
	public Account withdrawAmount(Account a, double withdrawAmount) {
		
		double amt = a.getAccountBalance();
		if(withdrawAmount <= amt) {
			double amt2 = a.getAccountBalance() - withdrawAmount;
			Account withdraw = new Account(a.getAccountNumber(),amt2);
			aDao.withdrawUserAmount(withdraw);
			System.out.println("Your new balance $ " + withdrawAmount );
			return withdraw;
			
		}else {
			System.out.println("You are not able to withdraw the current amount");
		}
		return null;
		
	}
	
	public Account addDepositAmount(Account a, double depositAmount) {
		double balance = a.getAccountBalance() + depositAmount;
		Account deposit = new Account(a.getAccountNumber(),balance);
		aDao.depositUserAmount(deposit);
		System.out.println("Your new balance $ " + balance );
		return deposit;
		
	}
	
	public Account transferAmount(int accountNumber, int accountNumber2, double transactionAmount) {
		try {
			Account send = new Account(accountNumber,transactionAmount);
			aDao.withdrawUserAmount(send);
			Account rec = new Account(accountNumber2,transactionAmount);
			aDao.depositUserAmount(rec);
			System.out.println("Your amount for $ " + transactionAmount+ " has been successfully transfered to  "+ accountNumber2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
