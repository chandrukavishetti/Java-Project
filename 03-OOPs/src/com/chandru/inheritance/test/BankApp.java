package com.chandru.inheritance.test;

import java.util.Scanner;
import com.chandru.inheritance.model.Account;
import com.chandru.inheritance.model.CurrentAccount;
import com.chandru.inheritance.model.SavingsAccount;

public class BankApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int choice;
		while (true) {
			System.out.println("Select Account Type:");
			System.out.println("1. Savings Account");
			System.out.println("2. Current Account");
			System.out.print("Enter choice: ");
			String input = scanner.nextLine().trim();

			boolean validChoice = true;
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					validChoice = false;
					break;
				}
			}

			if (!validChoice || input.isEmpty()) {
				System.out.println("Invalid choice. Enter 1 or 2.");
				continue;
			}

			choice = Integer.parseInt(input);
			if (choice == 1 || choice == 2)
				break;
			System.out.println("Select 1 or 2 only.");
		}

		String accNo;
		while (true) {
			System.out.print("Enter Account Number: ");
			accNo = scanner.nextLine().trim();
			if (accNo.isEmpty()) {
				System.out.println("Account Number cannot be blank.");
				continue;
			}
			boolean onlyDigits = true;
			for (int i = 0; i < accNo.length(); i++) {
				if (!Character.isDigit(accNo.charAt(i))) {
					onlyDigits = false;
					break;
				}
			}
			if (!onlyDigits) {
				System.out.println("Account Number must contain digits only.");
				continue;
			}
			break;
		}

		String name;
		while (true) {
			System.out.print("Enter Holder Name: ");
			name = scanner.nextLine().trim();
			if (name.isEmpty()) {
				System.out.println("Name cannot be blank.");
				continue;
			}
			boolean onlyAlpha = true;
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				if (!Character.isLetter(ch) && ch != ' ') {
					onlyAlpha = false;
					break;
				}
			}
			if (!onlyAlpha) {
				System.out.println("Name must contain alphabets and spaces only.");
				continue;
			}
			break;
		}

		double balance;
		while (true) {
			System.out.print("Enter Initial Balance: ");
			String input = scanner.nextLine().trim();
			if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
				System.out.println("Invalid format. No leading zeros allowed.");
				continue;
			}
			boolean isNumeric = true;
			int dotCount = 0;
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '.') {
					dotCount++;
					continue;
				}
				if (!Character.isDigit(ch)) {
					isNumeric = false;
					break;
				}
			}
			if (!isNumeric || dotCount > 1 || input.isEmpty()) {
				System.out.println("Invalid input. Enter numeric value only.");
				continue;
			}
			balance = Double.parseDouble(input);
			if (balance < 0) {
				System.out.println("Balance cannot be negative.");
				continue;
			}
			break;
		}

		Account account = null;

		if (choice == 1) {
			double minBalance;
			while (true) {
				System.out.print("Enter Minimum Balance: ");
				String input = scanner.nextLine().trim();
				if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
					System.out.println("Invalid format.");
					continue;
				}
				boolean isNumeric = true;
				int dotCount = 0;
				for (int i = 0; i < input.length(); i++) {
					char ch = input.charAt(i);
					if (ch == '.') {
						dotCount++;
						continue;
					}
					if (!Character.isDigit(ch)) {
						isNumeric = false;
						break;
					}
				}
				if (!isNumeric || dotCount > 1 || input.isEmpty()) {
					System.out.println("Invalid numeric amount.");
					continue;
				}
				minBalance = Double.parseDouble(input);
				if (minBalance >= 0)
					break;
				System.out.println("Cannot be negative.");
			}
			account = new SavingsAccount(accNo, name, balance, minBalance);
		} else if (choice == 2) {
			double overdraft;
			while (true) {
				System.out.print("Enter Overdraft Limit: ");
				String input = scanner.nextLine().trim();
				if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
					System.out.println("Invalid format.");
					continue;
				}
				boolean isNumeric = true;
				int dotCount = 0;
				for (int i = 0; i < input.length(); i++) {
					char ch = input.charAt(i);
					if (ch == '.') {
						dotCount++;
						continue;
					}
					if (!Character.isDigit(ch)) {
						isNumeric = false;
						break;
					}
				}
				if (!isNumeric || dotCount > 1 || input.isEmpty()) {
					System.out.println("Invalid numeric amount.");
					continue;
				}
				overdraft = Double.parseDouble(input);
				if (overdraft >= 0)
					break;
				System.out.println("Cannot be negative.");
			}
			account = new CurrentAccount(accNo, name, balance, overdraft);
		}

		while (true) {
			System.out.println("\n1. Deposit\n2. Withdraw\n3. Display Details\n4. Exit");
			System.out.print("Choose option: ");
			String optInput = scanner.nextLine().trim();

			boolean optValid = true;
			for (int i = 0; i < optInput.length(); i++) {
				if (!Character.isDigit(optInput.charAt(i))) {
					optValid = false;
					break;
				}
			}
			if (!optValid || optInput.isEmpty()) {
				System.out.println("Invalid choice.");
				continue;
			}

			int option = Integer.parseInt(optInput);

			if (option == 4) {
				System.out.println("Thank you!");
				break;
			}

			if (option == 1) {
				System.out.print("Enter deposit amount: ");
				String dInput = scanner.nextLine().trim();

				// Added Validation
				boolean dValid = true;
				int dDots = 0;
				for (int i = 0; i < dInput.length(); i++) {
					char ch = dInput.charAt(i);
					if (ch == '.') {
						dDots++;
						continue;
					}
					if (!Character.isDigit(ch)) {
						dValid = false;
						break;
					}
				}
				if (!dValid || dDots > 1 || dInput.isEmpty()
						|| (dInput.length() > 1 && dInput.startsWith("0") && !dInput.startsWith("0."))) {
					System.out.println("Invalid numeric amount.");
					continue;
				}

				account.deposit(Double.parseDouble(dInput));
				account.displayDetails();
				continue;
			}

			if (option == 2) {
				System.out.print("Enter withdrawal amount: ");
				String wInput = scanner.nextLine().trim();

				// Added Validation
				boolean wValid = true;
				int wDots = 0;
				for (int i = 0; i < wInput.length(); i++) {
					char ch = wInput.charAt(i);
					if (ch == '.') {
						wDots++;
						continue;
					}
					if (!Character.isDigit(ch)) {
						wValid = false;
						break;
					}
				}
				if (!wValid || wDots > 1 || wInput.isEmpty()
						|| (wInput.length() > 1 && wInput.startsWith("0") && !wInput.startsWith("0."))) {
					System.out.println("Invalid numeric amount.");
					continue;
				}

				account.withdraw(Double.parseDouble(wInput));
				account.displayDetails();
				continue;
			}

			if (option == 3) {
				account.displayDetails();
				continue;
			}

			System.out.println("Invalid option.");
		}

		scanner.close();
	}
}