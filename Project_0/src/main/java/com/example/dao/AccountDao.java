package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Account;
import com.example.models.AccountDisplay;
import com.example.models.Employee;
import com.example.models.User;

public interface AccountDao {

	void createAccount(Account a) throws SQLException;
	
	void updateAccount(Account a);
	
	void deleteAccount(Account a);
	
	public Account getAccountByAccountNum(int accountNumber);
	
	public void depositUserAmount(Account a);
	
	public void withdrawUserAmount(Account a);
	
	//public List<AccountDisplay> getAllAccounts();
	
	//public User getUsersAccounts(User u);
	
	//public User getUserByUsername(User u);	
	
	//public void addAmount(Account add);
	
	
	
}
