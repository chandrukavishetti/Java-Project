package com.chandru.LSP.Banking_System.test;

import com.chandru.LSP.Banking_System.model.*;

public class BankingTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();

		System.out.println("1. Savings Account");
		System.out.println("2. Current Account");
		System.out.println("3. Fixed Deposit Account");

		int choice = input.getInt("Enter account type: ");
		double balance = input.getDouble("Enter initial balance: ");

		Account account = null;

		switch (choice) {

		case 1:
			account = new SavingsAccount(balance);
			break;

		case 2:
			account = new CurrentAccount(balance);
			break;

		case 3:
			account = new FixedDepositAccount(balance);
			break;

		default:
			System.out.println(" Invalid choice");
			return;
		}

		double depositAmt = input.getDouble("Enter deposit amount: ");
		account.deposit(depositAmt);

		if (account instanceof Withdrawable) {
			double withdrawAmt = input.getDouble("Enter withdraw amount: ");
			((Withdrawable) account).withdraw(withdrawAmt);
		} else {
			System.out.println("Withdrawal not allowed for this account type!");
		}

		System.out.println("Final Balance: " + account.getBalance());
	}
}