package com.chandru.assignment_test.test;

import com.chandru.assignment_test.model.Account;
import com.chandru.assignment_test.model.SavingsAccount;
import com.chandru.assignment_test.model.CurrentAccount;
import com.chandru.assignment_test.model.AccountValidator;
import com.chandru.assignment_test.model.AccountRepository;
import com.chandru.assignment_test.model.AccountService;
import com.chandru.assignment_test.model.AccountInputHandler;

//import com.chandru.assignment_test.model.Account;
//import com.chandru.assignment_test.model.SavingsAccount;
//import com.chandru.assignment_test.model.CurrentAccount;
//import com.chandru.assignment_test.model.AccountValidator;
//import com.chandru.assignment_test.model.AccountRepository;
//import com.chandru.assignment_test.model.AccountService;
//import com.chandru.assignment_test.model.AccountInputHandler;

public class AccountTest {

	public static void main(String[] args) {

		AccountInputHandler input = new AccountInputHandler();

		AccountRepository repository = new AccountRepository(10);

		AccountService service = new AccountService(repository);

		boolean running = true;

		while (running) {

			System.out.println("\nBank Account System");
			System.out.println("1 Create Savings Account");
			System.out.println("2 Create Current Account");
			System.out.println("3 Display Accounts");
			System.out.println("4 Exit");

			int choice = input.getInt("Enter choice: ");

			try {

				switch (choice) {

				case 1:

					int sAccNo = input.getInt("Enter Account Number: ");
					String sName = input.getString("Enter Holder Name: ");
					double sBal = input.getDouble("Enter Balance: ");

					Account savings = new SavingsAccount(sAccNo, sName, sBal);
					service.addAccount(savings);

					break;

				case 2:

					int cAccNo = input.getInt("Enter Account Number: ");
					String cName = input.getString("Enter Holder Name: ");
					double cBal = input.getDouble("Enter Balance: ");

					Account current = new CurrentAccount(cAccNo, cName, cBal);
					service.addAccount(current);

					break;

				case 3:

					service.displayAccounts();
					break;

				case 4:

					running = false;
					System.out.println("Program Ended");
					break;

				default:

					System.out.println("Invalid choice");
				}

			} catch (IllegalArgumentException e) {

				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}