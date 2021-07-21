package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.models.Account;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{
	
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createAccount(Account a) throws SQLException {
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql="INSERT INTO account(account_number, account_balance) values"
					+ "(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAccountNumber());
			ps.setInt(2, a.getAccountBalance());
			
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(Account a) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET account_number = ?, account_balance = ?"
					+ "WHERE accounts.id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAccountNumber());
			ps.setInt(2, a.getAccountBalance());
			ps.setInt(3,a.getAccountId());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(Account a) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM accounts WHERE accounts.account_id = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setInt(1,a.getAccountId());
					
					ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void depositUserAmount(Account a) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET account_balance =account_balance+? WHERE account_number= ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAccountId());
			ps.setInt(2,a.getAccountBalance());
			
			ps.execute();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdrawUserAmount(Account a) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET account_balance =account_balance-? WHERE account_number= ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAccountId());
			ps.setInt(2, a.getAccountBalance());
			
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account getAccountByAccountNum(int accountNumber) {
		Account account = new Account();
		try {
			Connection con = conUtil.getConnection();
			
			String sql ="SELECT * FROM accounts WHERE accounts.account_number= " + accountNumber;
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setAccountNumber(rs.getInt(2));
				account.setAccountBalance(rs.getInt(3));
			}
			return account;
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
