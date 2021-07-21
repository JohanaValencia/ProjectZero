package com.example.services;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.exceptions.AccountAlreadyExistsException;
import com.example.exceptions.InvalidAccountException;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.AccountDisplay;
import com.example.models.User;

public class AccountService {

	private AccountDao aDao;
	
	public AccountService(AccountDao a) {
		this.aDao = a;
	}
	
	public Account createAccount(int accountNumber, int accountBalance) {
		Account a = new Account(accountNumber, accountBalance);
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
		Account a = aDao.getAccountByAccountNum(accountNumber);
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
	
	
	public Account deleteAccount(int accountNumber) {
		Account a = aDao.getAccountByAccountNum(accountNumber);
		if(a.getAccountNumber()== accountNumber) {
			Account delete = new Account(accountNumber);
			aDao.deleteAccount(delete);
			System.out.println("Your account has been deactivated. Good Bye");
		}else {
			System.out.println("Invalid account number was provided");
		}
		return a;
	
		}
	
	
	public Account withdrawAmount(Account a, int withdrawAmount) {
		
		int amt = a.getAccountBalance();
		if(amt >= withdrawAmount) {
			int amt2 = a.getAccountBalance() - withdrawAmount;
			Account withdraw = new Account(a.getAccountId(),amt2,a.getAccountNumber());
			aDao.withdrawUserAmount(withdraw);
			System.out.println("Your new balance $ " + withdrawAmount );
			return withdraw;
			
		}else {
			System.out.println("You are not able to withdraw the current amount");
		}
		return null;
		
	}
	
	public Account addDeposit(Account a, int depositAmount) {
		int balance = a.getAccountBalance() + depositAmount;
		Account deposit = new Account(a.getAccountId(),balance, a.getAccountNumber());
		aDao.depositUserAmount(deposit);
		System.out.println("Your new balance $ " + balance );
		return deposit;
		
	}
	

}

	/*
	public Account addDeposit(int accountNumber, int accountBalance) {
		if(accountBalance >= 0) {
			Account add = new Account(accountNumber, accountBalance);
			aDao.addAmount(add);
			System.out.println("You new balance is $ " + accountBalance );
			return add;
		}else {
			System.out.println("Invalid amount");
		}
		
		return null;
	}
	public Account withdrawAmount(int account,int accountBalance, int transaction_amount) {
		if(transaction_amount > 0 && accountBalance <0 ) {
			Account withdraw = new Account(account, transaction_amount);
			aDao.withdrawUserAmount(withdraw);
			System.out.println("Your balance has been updated to reflect your transaction $ "+ transaction_amount);
			return withdraw;
		}else {
			System.out.println("Invalid amount");
		}
		
		return null;
		
	}
	
	public Account transeferAmount(int accountIdS, int accountIdR, int transaction_amount) {
	
	try {
		
		Account sen = new Account(accountIdS,transaction_amount);
		aDao.withdrawUserAmount(sen);
		Account rec = new Account(accountIdR, transaction_amount);
		aDao.depositUserAmount(rec);
		System.out.println("Your $ " + transaction_amount + "has been withdrawn from the account " + accountIdS + "and has been successfully deposited to " + accountIdR);
	}catch (Exception e) {
		System.out.println();
	}
	return null;
	}
	
	public Account viewAccount(int account) {
		Account a = aDao.getAccountByUsername(account);
		return a;
		
	}
	
	public Account deleteAccount(int userAccount) {
		Account del = new Account(userAccount);		
		return del;
		
	}
	
	public List<AccountDisplay> getAllAccounts(){
		return aDao.getAllAccounts();
	}
	
	
	public User loadUserAccounts(User u) {
		return aDao.getUsersAccounts(u);
	}
	
		public Account updateAccount(int accountNumber) {
		Account a = aDao.getAccountByAccountNum(accountNumber);
		if(a.getAccountNumber()== accountNumber) {
			Account update = new Account(accountNumber);
			aDao.updateAccount(update);
		System.out.println("Your account has been updated");
	} else {
		System.out.println("Invalid account number was provided");
	}
		
		return a;

	}
	
	*/


