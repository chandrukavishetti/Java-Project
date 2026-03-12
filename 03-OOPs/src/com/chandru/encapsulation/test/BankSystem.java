package com.chandru.encapsulation.test;

import java.util.Scanner;
import com.chandru.encapsulation.model.BankAccount;

public class BankSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String name;
		double initialDeposit;

		while (true) {
			System.out.print("Enter Account Holder Name: ");
			name = scanner.nextLine().trim();

			if (name.isEmpty()) {
				System.out.println("Invalid name. Name cannot be blank.");
				continue;
			}

			boolean hasInvalid = false;
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				if (!Character.isLetter(ch) && ch != ' ') {
					hasInvalid = true;
					break;
				}
			}

			if (hasInvalid) {
				System.out.println("Invalid name. Only alphabets and spaces are allowed.");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("Enter Initial Deposit: ");
			String input = scanner.next().trim();

			if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
				System.out.println("Invalid format. Numbers should not start with leading zeros.");
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

			if (!isNumeric || dotCount > 1) {
				System.out.println("Invalid input. Enter numeric value only.");
				continue;
			}

			initialDeposit = Double.parseDouble(input);
			if (initialDeposit < 0) {
				System.out.println("Deposit cannot be negative.");
				continue;
			}
			break;
		}

		BankAccount account = new BankAccount(name, initialDeposit);

		int choice;

		do {
			System.out.println("\n1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Choose option: ");

			String choiceInput = scanner.next();
			boolean choiceValid = true;
			for (int i = 0; i < choiceInput.length(); i++) {
				if (!Character.isDigit(choiceInput.charAt(i))) {
					choiceValid = false;
					break;
				}
			}

			if (!choiceValid) {
				System.out.println("Invalid choice. Enter number.");
				choice = 0;
				continue;
			}

			choice = Integer.parseInt(choiceInput);

			switch (choice) {

			case 1:
				System.out.print("Enter deposit amount: ");
				String dInput = scanner.next();

				// Manual Numeric Validation (to avoid Exception)
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

				if (!dValid || dDots > 1
						|| (dInput.length() > 1 && dInput.startsWith("0") && !dInput.startsWith("0."))) {
					System.out.println("Invalid input. Enter a valid numeric amount without leading zeros.");
					break;
				}

				account.deposit(Double.parseDouble(dInput));
				break;

			case 2:
				System.out.print("Enter withdrawal amount: ");
				String wInput = scanner.next();

				// Manual Numeric Validation (to avoid Exception)
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

				if (!wValid || wDots > 1
						|| (wInput.length() > 1 && wInput.startsWith("0") && !wInput.startsWith("0."))) {
					System.out.println("Invalid input. Enter a valid numeric amount without leading zeros.");
					break;
				}

				account.withdraw(Double.parseDouble(wInput));
				break;

			case 3:
				System.out.println("Current Balance: " + account.getBalance());
				break;

			case 4:
				System.out.println("Thank you!");
				break;

			default:
				System.out.println("Invalid option.");
			}

		} while (choice != 4);

		scanner.close();
	}
}