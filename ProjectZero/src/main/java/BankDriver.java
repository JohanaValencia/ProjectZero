import java.util.Scanner;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
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
				System.out.println(
						"Login or Signup?\nPress 1.Login\nPress 2.Signup\nPress 3.Open an Account\nPress 4.View Account\nPress 5.Close Account\nPress 6.Update Account\nPress 7.Withdraw\nPress 8.Deposit\nPress 9.Transfer funds");
				int choice = Integer.parseInt(in.nextLine());
				if (choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					try {
						u = uServ.signIn(username, password);
						System.out.println("Welcome " + u.getFirstName() + "!");
						System.out.println(
								"Login or Signup?\nPress 1.Login\nPress 2.Signup\nPress 3.Open an Account\nPress 4.View Account\nPress 5.Close Account\nPress 6.Update Account\nPress 7.Withdraw\nPress 8.Deposit\nPress 9.Transfer funds");

					} catch (Exception e) {
						System.out.println("Username or password was incorect. Goodbye");
						done = true;
					}
				} else if (choice == 2) {
					System.out.print("Please enter your first name: ");
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
								"Login or Signup?\nPress 1.Login\nPress 2.Signup\nPress 3.Open an Account\nPress 4.View Account\nPress 5.Close Account\nPress 6.Update Account\nPress 7.Withdraw\nPress 8.Deposit\nPress 9.Transfer funds");
						continue;
					} catch (Exception e) {
						System.out.println("Sorry, we could not process your request");
						System.out.println("Please try again later");
						done = true;

					}
				} else if (choice == 3) {
					System.out.println("You can only create an account if you have signed up and received an ID");
					System.out.print("Please enter your ID: ");
					int id = in.nextInt();
					System.out.print("Please enter the amount you wish to start you account with: ");
					double accountBalance = in.nextDouble();
					try {
						a = aServ.createAccount(id, accountBalance);
						System.out.println("Your account number is " + a.getAccountNumber());
					} catch (Exception e) {
						System.out.println("Sorry we could not process your request");
						System.out.println("Please try again later");
					}
				}
			}
		}
	}
}
