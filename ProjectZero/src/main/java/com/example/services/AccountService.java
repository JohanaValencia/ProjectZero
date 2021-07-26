
package com.example.services;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.example.dao.AccountDao;
import com.example.exceptions.AccountAlreadyExistsException;
import com.example.exceptions.InvalidAccountException;
import com.example.exceptions.InvalidAmountException;
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
		try {
			aDao.deleteAccount(a);
			Logging.logger.info("You have successfully closed your account " + a.getAccountNumber());
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InvalidAccountException();
		}
		
		return a;
		
		}
	
	
	
	
	//Use for employee to update balance and account number (Double check this method here and in aDao)
	public Account updateAccount(int accountNumber, double accountBalance) {
		Account a = new Account(accountNumber, accountBalance);
		if(a.getAccountNumber()== accountNumber) {
			try {
				aDao.updateAccount(a);
				Logging.logger.info("You have successfully updated the account number:\nThe new account number is " + a.getAccountNumber()+" The new account balance is now: "+a.getAccountBalance());
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new InvalidAccountException();
			}
		
		}
		return a;
		}
	
	
public Account withdrawAmount(Account a, double withdrawAmount) {
        
        double amt = a.getAccountBalance();
        System.out.println("Old Account Balance =" + amt);
        if(amt >= withdrawAmount) {
            double amt2 = a.getAccountBalance() - withdrawAmount;
            Account withdraw = new Account(a.getAccountId(),a.getCustomerId(),a.getAccountNumber(),amt2);
            System.out.println(withdraw);
            aDao.withdrawUserAmount(withdraw);
            System.out.println("New Account Balance =" + amt2);
            System.out.println("The amount you withdrew is$ " + withdrawAmount );
            return withdraw;
            
        }else {
            System.out.println("You are not able to withdraw the current amount");
        }
        return null;
        
    }

	
	public Account addDepositAmount(Account a, double depositAmount) {
		double balance = a.getAccountBalance() + depositAmount;
		Account deposit = new Account(a.getAccountId(),a.getCustomerId(),a.getAccountNumber(),balance);
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
