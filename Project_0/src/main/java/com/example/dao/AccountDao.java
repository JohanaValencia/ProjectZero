package com.example.dao;

import java.util.List;

import com.example.model.Account;
import com.example.model.AccountDisplay;
import com.example.model.User;

public interface AccountDao {

	public void createAccount(Account a);
	
	public List<AccountDisplay> getAllAccounts();
	
	public User getUsersAccounts(User u);
	
}
