package com.chandru.Interface.test;

import com.chandru.Interface.model.AccountOperations;
import com.chandru.Interface.model.SavingAccount;
import com.chandru.Interface.model.LoanAccount;
import com.chandru.Interface.model.CurrentAccount;
import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AccountOperations account = null;

		System.out.println("====== Welcome to Banking System ======");

		int accountChoice = 0;

		while (accountChoice < 1 || accountChoice > 3) {

			System.out.println("Select Account Type:");
			System.out.println("1. Savings Account");
			System.out.println("2. Current Account");
			System.out.println("3. Loan Account");

			if (scanner.hasNextInt()) {
				accountChoice = scanner.nextInt();

				if (accountChoice < 1 || accountChoice > 3) {
					System.out.println("Invalid choice. Select between 1 and 3.");
				}
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
			}
		}

		switch (accountChoice) {

		case 1:
			account = new SavingAccount(20000);
			break;

		case 2:
			account = new CurrentAccount(15000);
			break;

		case 3:
			account = new LoanAccount(50000);
			break;
		}

		boolean continueTransaction = true;

		while (continueTransaction) {

			System.out.println("\nChoose Operation:");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");

			int operation = 0;

			if (scanner.hasNextInt()) {
				operation = scanner.nextInt();
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
				continue;
			}

			switch (operation) {

			case 1:
				double depositAmount = getValidAmount(scanner);
				account.deposit(depositAmount);
				break;

			case 2:
				double withdrawAmount = getValidAmount(scanner);
				account.withdraw(withdrawAmount);
				break;

			case 3:
				account.checkBalance();
				break;

			case 4:
				continueTransaction = false;
				System.out.println("Thank you for using Banking System.");
				break;

			default:
				System.out.println("Invalid operation. Choose between 1 and 4.");
			}
		}

		scanner.close();
	}

	private static double getValidAmount(Scanner scanner) {

		double amount = 0;

		while (amount <= 0) {

			System.out.println("Enter Amount:");

			if (scanner.hasNextDouble()) {
				amount = scanner.nextDouble();

				if (amount <= 0) {
					System.out.println("Amount must be greater than 0.");
				}
			} else {
				System.out.println("Invalid input. Enter numbers only.");
				scanner.next();
			}
		}

		return amount;
	}
}