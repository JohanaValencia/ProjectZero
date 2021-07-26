package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Account;
import com.example.models.Employee;
import com.example.models.Transaction;
import com.example.models.User;

public interface AccountDao {

	List<Account> getAllAccounts();
	
	List<Transaction> getAllTransactions();
	
	Account getAccountByAccountNumber(Account accountNumber);
	
	Account getAccountByAccountNumber(int accountNumber);
	
	Account getAccountByCustomerId(int customerId);
	
	Account getAccountByCustomerId(Account a);	
			
	void createAccount(Account a) throws SQLException;
	
	void updateAccount(Account a) throws SQLException;
	
	void deleteAccount(Account a) throws SQLException;
	
	public void withdrawUserAmount(Account a);

	void depositUserAmount(Account a);
	
	void logTransactions(Account sen, Account rec, double transferAmount);
	
	void addTransactionAmount(Account a);
	
	Account viewAccount(int accountNumber);

	//void withdrawAccount(Account a) throws SQLException;

	
	//Account viewAccountByUser(User u);

	
	//public void depositUserAmount(int accountNumber, double accountBalance);
	
	//public void getAccountByUser(User u);
	
	//public User getUsersAccounts(User u);
	
	//public User getUserByUsername(User u);	
	
	//public void addAmount(Account add);
	
	
	
}