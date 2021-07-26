import java.sql.SQLException;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.Account;
import com.example.models.User;
import com.example.services.AccountService;
import com.example.services.UserService;

public class BankDriverTesting {

	
public static void main(String[] args)  {
	
	
	//Dont forget you need this 
	UserDao uDao = new UserDaoDB();
	
	AccountDao aDao = new AccountDaoDB();

	UserService uServ = new UserService(uDao);
	
	AccountService aServ = new AccountService(aDao);
	
	
	//How you get a list of all the users and or accounts
	//System.out.println(uDao.getAllUsers());
	
	
	//System.out.println(aDao.getAllAccounts());
	
	
//----------------------------------------------------------------
	//How you get an account by account by account number 
	
	//System.out.println(aDao.getAccountByAccountNumber(379449119));
	
	//How you get user by username
	
	//Account a = new Account();
	//System.out.println(aDao.getAccountByAccountNumber(379449119));
	//User user = new User();
	//System.out.println(uDao.getUserByUsername());
	//System.out.println(uDao.getUserByUsername("johanavalencia5656"));
//---------------------------------------------------------------------	

	//How you create a new user 
	//User u = new User("Amanda","Torres","at@mail.com","at");
	//uDao.createUser(u);
	//System.out.println(uDao.getAllUsers());
	
	//How you create a new account
	//Account a = new Account(7,5000);
	//aDao.createAccount(a);
	//System.out.println(aDao.getAllAccounts());
//-------------------------------------------------------------------	
	//This is how you get account by account number and delete it 
	//Account a = aDao.getAccountByAccountNumber(464785184);
	//aDao.deleteAccount(a);
	//System.out.println(aDao.getAllAccounts());
//------------------------------------------------------------------------
		
	//How to update account balance or any other variable in database table
	
	//System.out.println(aDao.getAccountByAccountNumber(379449119));
	
	//Account a= aDao.getAccountByAccountNumber(379449119);
	
	//a.setAccountNumber(123456789);
	
	//aDao.updateAccount(a);
	
	//System.out.println(aDao.getAccountByAccountNumber(123456789));
	
	//System.out.println(aDao.getAllAccounts());
//-------------------------------------------------------------------
	
	
	System.out.println( aDao.getAccountByAccountNumber(123456789));
	
	Account a= new Account (123456789, 2000.00);
	
	aDao.withdrawUserAmount(a);
	
	System.out.println(aDao.getAccountByAccountNumber(123456789));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 	if(login) {
					System.out.println("Please Select from the following options");
					System.out.println("1. View account balance \n2. Create a new account\n3. Deposit\n4. Withdraw\n5. transfer\n6. Quit");
					int option = Integer.parseInt(in.nextLine());
					if(option == 1) {
						System.out.println("Your current account balance is: $" + aDao.getAccountByAccountNumber(a).getAccountBalance());
						done=true;
					}else if(option == 2) {
						System.out.print("Please enter your ID: ");
						int id= in.nextInt();
						System.out.println("Please enter the amount you wish to start you account with: ");
						double accountBalance= in.nextDouble();
						try {
							a= aServ.createAccount(id, accountBalance);
							System.out.println("Your account number is " + a.getAccountNumber());
							}catch(Exception e) {
								System.out.println("Sorry we could not process your request");
								System.out.println("Please try again later");
							}
	 
	 
	
	*/
	//Account a= aServ.createAccount(7, 500000.00);
	//Account b = aServ.createAccount(8, 500.00);
	//Account a = new Account()
	
	
	
	

	
}
	

}
