import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.exceptions.InvalidAccountException;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.models.Account;
import com.example.models.User;
import com.example.services.AccountService;
import com.example.services.UserService;

public class BankDriver {
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static AccountDao aDao = new AccountDaoDB();
	private static AccountService aServ = new AccountService(aDao);

	public static void main(String[] args) {
		System.out.println("Welcome to Johana's Bank");
		Scanner in = new Scanner(System.in);
		// User u = new User();
		// isEmp.setEmployee(false);
		boolean done = false;

		User u = null;
		Account a = new Account();

		while (!done) {
			if (u == null) {
				boolean login = false;
				System.out.println("Login or Signup?\nPress 1.Login\nPress 2.Signup");
				int choice = Integer.parseInt(in.nextLine());
				if (choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					try {
						u = uServ.signIn(username, password);
						System.out.println("Welcome " + u.getFirstName() + "!");
						login = true;
					} catch (Exception e) {
						Logger.getLogger(UserDoesNotExistException.class);
						System.out.println("Username or password was incorect. Goodbye");
						done = true;
					}
					if (login) {
						System.out.println("Please select from the options below");
						System.out.println(
								"Press 1.View Account\nPress 2.Close Account\nPress 3.Withdraw\nPress 4.Deposit\nPress 5.Transfer funds\nPress 6.Quit");
						choice = Integer.parseInt(in.nextLine());
						if (choice == 1) {
							System.out.print("Please enter your account number: ");
							int accountNumber = in.nextInt();
							try {
								a = aServ.viewAccountByAccountNum(accountNumber);
								done = true;
							} catch (Exception e) {
								Logger.getLogger(InvalidAccountException.class);
								System.out.println("The account number provided was incorrect please try again");
							}
						} else if (choice == 2) {
							System.out.print("Please enter your account number: ");
							int accountNumber = in.nextInt();
							try {
								a = aServ.deleteAccount(accountNumber);
							} catch (Exception e) {
								Logger.getLogger(InvalidAccountException.class);
								System.out.println("The account number you provided was incorrect please try again");
							}
						} else if (choice == 3) {
							try {
								System.out.println("Please enter the account number you would like to withdraw from: ");
								int accountNumber = in.nextInt();
								Account acc = aDao.getAccountByAccountNumber(accountNumber);
								System.out.print(acc);
								System.out.print("Please enter the amount of money you wish to withdraw $");
								double withdraw = in.nextDouble();
								a = aServ.withdrawAmount(acc, withdraw);
								} catch (Exception e) {
								Logger.getLogger(InvalidAccountException.class);
								System.out.println("The account number you provided was incorrect please try again");
							}
						}else if (choice == 4 ) {
							try {
								System.out.println("Please enter the account number you would like to deposit to: ");
								int accountNumber = in.nextInt();
								Account acc = aDao.getAccountByAccountNumber(accountNumber);
								System.out.println(acc);
								System.out.print("Please enter the amount of money you wish to deposit $");
								double deposit = in.nextDouble();
								a = aServ.addDepositAmount(acc, deposit);
							}catch(Exception e) {
								Logger.getLogger(InvalidAccountException.class);
								System.out.println("The account number you provided was incorrect please try again");
							}
						}else if (choice == 5) {
							try {
								Account sender = aDao.getAccountByCustomerId(u.getId());
								System.out.print("Please enter the account number you'd like to transfer to:");
								int rec = in.nextInt();
								Account receiver = aDao.getAccountByAccountNumber(rec);
								System.out.print("How much would you like to send?");
								double transfer = in.nextDouble();
								// a = aServ.transferAmount(u.getId(), receiver_id, transfer);
								Account as = aServ.withdrawAmount(sender, transfer);
								aDao.withdrawUserAmount(as);
								Account ar = aServ.addDepositAmount(receiver, transfer);
								aDao.depositUserAmount(ar);								
							}catch(Exception e) {
								Logger.getLogger(InvalidAccountException.class);
								System.out.println("The account number you provided was incorrect please try again");
							}
						}else{
							login=true;
							System.out.println("Good Bye:)");
						}
					}

				} else if (choice == 2) {
					System.out.print("Please enter you first name: ");
					String first = in.nextLine();
					System.out.print("Please enter your last name: ");
					String last = in.nextLine();
					System.out.print("Please enter your email: ");
					String email = in.nextLine();
					System.out.print("Please enter a password: ");
					String password = in.nextLine();
					try {
						u = uServ.signUp(first, last, email, password);
						System.out.println("You may now log in with the username: " + u.getUsername());
						System.out.println(
								"--------------------- !!!!!WARNING!!!!!------------------------ \n   !!!!!PLEASE RECORD ID TO CREATE AN ACCOUNT & ALL INFORMATION PROVIDED!!!!! \n "
										+ uDao.getUserByUsername(u.getUsername()));
						System.out.println(
								"Now that you have registered lets go ahead and create your bank account with the ID provided above ");
						System.out.print("Please enter your ID: ");
						int id = in.nextInt();
						System.out.print("Please enter the amount you wish to start you account with: ");
						double accountBalance = in.nextDouble();
						try {
							a = aServ.createAccount(id, accountBalance);
							System.out.println("Your account number is " + a.getAccountNumber());
							done = true;

						} catch (Exception e) {
							Logger.getLogger(InvalidAccountException.class);
							System.out.println("Sorry we could not process your request");
							System.out.println("Please try again later");
						}
					} catch (Exception e) {
						Logger.getLogger(UserNameAlreadyExistsException.class);
						System.out.println("Sorry, we could not process your request");
						System.out.println("Please try again later");
						done = true;
					}
				}
			}else {
				System.out.println("Good Bye:)");
			}
		}
	}
}
