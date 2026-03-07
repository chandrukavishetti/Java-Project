package com.chandru.constructor.test;

import com.chandru.constructor.model.BankAccount;
import com.chandru.constructor.model.PremiumAccount;
import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String accountHolderName1;
		while (true) {
			System.out.print("Enter the 1st Account holder name: ");
			accountHolderName1 = scanner.nextLine().trim();

			if (accountHolderName1.isEmpty()) {
				System.out.println("Account holder name cannot be blank.");
				continue;
			}

			boolean hasInvalid = false;
			for (int i = 0; i < accountHolderName1.length(); i++) {
				char ch = accountHolderName1.charAt(i);
				if (!Character.isLetter(ch) && ch != ' ') {
					hasInvalid = true;
					break;
				}
			}

			if (hasInvalid) {
				System.out.println("Name should contain only alphabets and spaces.");
				continue;
			}
			break;
		}

		String accountHolderName2;
		while (true) {
			System.out.print("Enter the 2nd Account holder name: ");
			accountHolderName2 = scanner.nextLine().trim();

			if (accountHolderName2.isEmpty()) {
				System.out.println("Account holder name cannot be blank.");
				continue;
			}

			boolean hasInvalid = false;
			for (int i = 0; i < accountHolderName2.length(); i++) {
				char ch = accountHolderName2.charAt(i);
				if (!Character.isLetter(ch) && ch != ' ') {
					hasInvalid = true;
					break;
				}
			}

			if (hasInvalid) {
				System.out.println("Name should contain only alphabets and spaces.");
				continue;
			}
			break;
		}

		double balance;
		while (true) {
			System.out.print("Enter balance amount for 2nd account: ");

			if (!scanner.hasNextDouble()) {
				System.out.println("Invalid input. Please enter numbers only.");
				scanner.next();
				continue;
			}

			balance = scanner.nextDouble();
			scanner.nextLine();

			if (balance < 0) {
				System.out.println("Balance cannot be negative.");
				continue;
			}
			break;
		}

		String premiumName;
		while (true) {
			System.out.print("Enter the Premium Account holder name: ");
			premiumName = scanner.nextLine().trim();

			if (premiumName.isEmpty()) {
				System.out.println("Account holder name cannot be blank.");
				continue;
			}

			boolean hasInvalid = false;
			for (int i = 0; i < premiumName.length(); i++) {
				char ch = premiumName.charAt(i);
				if (!Character.isLetter(ch) && ch != ' ') {
					hasInvalid = true;
					break;
				}
			}

			if (hasInvalid) {
				System.out.println("Name should contain only alphabets and spaces.");
				continue;
			}
			break;
		}

		double premiumBalance;
		while (true) {
			System.out.print("Enter balance amount for Premium account: ");

			if (!scanner.hasNextDouble()) {
				System.out.println("Invalid input. Please enter numbers only.");
				scanner.next();
				continue;
			}

			premiumBalance = scanner.nextDouble();
			scanner.nextLine();

			if (premiumBalance < 0) {
				System.out.println("Balance cannot be negative.");
				continue;
			}
			break;
		}

		BankAccount acc1 = new BankAccount(accountHolderName1);
		System.out.println("\nAccount 1 Balance: " + acc1.getBalance());

		BankAccount acc2 = new BankAccount(accountHolderName2, balance);
		System.out.println("Account 2 Balance: " + acc2.getBalance());

		PremiumAccount pAcc = new PremiumAccount(premiumName, premiumBalance);
		System.out.println("Premium Account Balance (with bonus): " + pAcc.getBalance());

		System.out.println("Interest Rate: " + BankAccount.getInterestRate());

		scanner.close();
	}
}