
package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.models.Transaction;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao {

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public List<Account> getAllAccounts() {

		List<Account> accountList = new ArrayList<Account>();
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM accounts";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
			}
			return accountList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account getAccountByAccountNumber(Account accountNumber) {
		Account account = new Account();
		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM accounts WHERE accounts.account_number= " + accountNumber;

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setCustomerId(rs.getInt(2));
				account.setAccountNumber(rs.getInt(3));
				account.setAccountBalance(rs.getDouble(4));
			}
			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account getAccountByAccountNumber(int accountNumber) {
		Account account = new Account();
		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM accounts WHERE accounts.account_number= " + accountNumber;

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setCustomerId(rs.getInt(2));
				account.setAccountNumber(rs.getInt(3));
				account.setAccountBalance(rs.getDouble(4));
			}
			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createAccount(Account a) throws SQLException {
		try {
			Connection con = conUtil.getConnection();
			String sql = "INSERT INTO accounts(customer_id, account_number, account_balance) values" + "(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, a.getCustomerId());
			ps.setInt(2, a.getAccountNumber());
			ps.setDouble(3, a.getAccountBalance());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(Account a) throws SQLException {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET customer_id = ?, account_number = ?, account_balance = ?"
					+ "WHERE accounts.account_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, a.getCustomerId());
			ps.setInt(2, a.getAccountNumber());
			ps.setDouble(3, a.getAccountBalance());
			ps.setInt(4, a.getAccountId());

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(Account a) throws SQLException {

		try {
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM accounts WHERE accounts.account_number = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, a.getAccountNumber());

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void depositUserAmount(Account a) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET account_balance = ? WHERE customer_id= ? AND account_number = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, a.getAccountBalance());
			ps.setInt(2, a.getCustomerId());
			ps.setInt(3, a.getAccountNumber());


			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdrawUserAmount(Account a) {

		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accounts SET account_balance = ? WHERE customer_Id= ? AND account_number = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, a.getAccountBalance());
			ps.setInt(2, a.getCustomerId());
			ps.setInt(3,a.getAccountNumber());
			
			

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	public void logTransactions(Account sen, Account rec, double transferAmount) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "INSERT INTO transactions(account_sen, account_rec,transaction_amount)values" + "(?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, sen.getAccountNumber());
			ps.setInt(2, rec.getAccountNumber());
			ps.setDouble(3, transferAmount);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addTransactionAmount(Account a) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "INSERT INTO accounts(acount_number, account_balance) values" + "(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getAccountNumber());
			ps.setDouble(2, a.getAccountBalance());

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Account viewAccount(int accountNumber) {
		Account a = new Account();
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT SUM(account_balance) FROM accounts WHERE account_number=" + accountNumber;
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				a.setAccountNumber(rs.getInt(1));
				a.setAccountBalance(rs.getDouble(2));
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Transaction> getAllTransactions() {

		List<Transaction> transactionList = new ArrayList<Transaction>();
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM transactions";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				transactionList.add(new Transaction(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
			}
			return transactionList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account getAccountByCustomerId(int customerId) {
		Account account = new Account();
		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM accounts WHERE accounts.customer_id= " + customerId;

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setCustomerId(rs.getInt(2));
				account.setAccountNumber(rs.getInt(3));
				account.setAccountBalance(rs.getDouble(4));
			}
			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account getAccountByCustomerId(Account a) {
		Account account = new Account();

		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT * FROM accounts WHERE accounts.customer_id = '" + a.getCustomerId() + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				account.setCustomerId(rs.getInt(1));
				account.setAccountNumber(rs.getInt(2));
				account.setAccountBalance(rs.getDouble(3));
				account.setAccountId(rs.getInt(4));
			}
			return a;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


}
