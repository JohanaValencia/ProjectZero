package com.example.services;

import java.util.List;

import com.example.dao.AccountDao;
import com.example.model.Account;
import com.example.model.AccountDisplay;
import com.example.model.User;

public class AccountService {

	private AccountDao aDao;
	
	public AccountService(AccountDao a) {
		this.aDao = a;
	}
	//----------------------V as about this value??
	public void addAccount(int accountId, int accountNumber, int accountBalance) {
		Account a = new Account(accountId,accountNumber,accountBalance);
		aDao.createAccount(a);
	}
	
	public List<AccountDisplay> getAllAccounts(){
		return aDao.getAllAccounts();
	}
	
	public User loadUserAccounts(User u) {
		return aDao.getUsersAccounts(u);
	}
	
}
