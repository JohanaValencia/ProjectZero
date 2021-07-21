import java.util.Scanner;

import com.example.dao.AccountDao;
import com.example.dao.AccountDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.User;
import com.example.services.AccountService;
import com.example.services.EmployeeServices;
import com.example.services.UserService;


import java.util.Scanner;

public class BankDriver {

	private static UserDao uDao = new UserDaoDB();
	private static AccountDao aDao = new AccountDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static AccountService aServ = new AccountService(aDao);
	private static EmployeeServices eServ = new EmployeeService(eDao);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Johana's bank!");
		Scanner scan = new Scanner(System.in);
		String input = "";
		do {
			System.out.println("Are you a customer or employee?");
			input = scan.next();
			if (input != null) {
				switch (input.toLowerCase()) {
				case "customer":
					System.out.println("Would you like to (login) or (create) a new account?");
					input = scan.next();
					switch (input.toLowerCase()) {
					case "login":
						// <-- minimize this -->
						// try
						// CustomerServices.login
						System.out.println("Please enter your username: ");
						String username = scan.nextLine();
						System.out.println("Please enter your password: ");
						String password = scan.nextLine();
						try {
							// u = uServ.login(username, password);
							// System.out.println("Welcome " + u.getFirstName());
						} catch (Exception e) {
							System.out.println("Username or password was incorect. Goodbye");
							// done = true;
						}
						// <------------------------->
						break;
					case "create":
						// try
						// customerServices.createNewAccount
						// <-- minimize this -->
						System.out.print("Please enter you first name: ");
						String firstName = scan.nextLine();
						System.out.println("Please enter your last name: ");
						String lastName = scan.nextLine();
						System.out.println("Please enter a password: ");
						// String password = scan.nextLine();
						try {
							// u = uServ.signUp(first, last, password);
							// System.out.println("You may now log in with the username: " +
							// u.getUsername());
						} catch (Exception e) {
							System.out.println("Sorry, we could not process your request");
							System.out.println("Please try again later");
							// done = true;
						}
						// <------------------------->
						break;
					default:
						System.out.println("");
						System.out.println("input read: " + input.toLowerCase());
						break;
					}
					break;
				case "employee":
					System.out.println("Please Login");
					// managerservices.login
					break;
				case "quit":
					scan.close();
					System.exit(0);
				default:
					System.out.println("I couldn't understand that please try again");
					break;
				}
			}
		} while (!input.equals("quit"));
		// might jump down here once logged in will have to fix while loop
	}

}