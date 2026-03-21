package com.chandru.practice.test;

import java.util.Scanner;

import com.chandru.practice.model.BankAccount;

public class BankAccountTest {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("enter the account number ");

		int accNumber = scanner.nextInt();

		BankAccount bank = new BankAccount(accNumber, 100);

		double dAmt = getAmount();
		bank.deposit(dAmt);

		double wAmt = getWithdrawAmount();
		bank.withdraw(wAmt);

		System.out.println("account number is : " + bank.getAccountNumber());
		System.out.println("account balance : " + bank.getBalance());

	}

	public static double getAmount() {
		System.out.println("enter the amount to deposit");
		double depositAmt = scanner.nextDouble();
		if (depositAmt <= 0) {
			System.out.println("enter the positive number to deposit");
			scanner.nextLine();
		}
		return depositAmt;
	}

	public static double getWithdrawAmount() {
		System.out.println("enter the amount to withdraw ");
		double withdrawAmt = scanner.nextDouble();
		return withdrawAmt;
	}
}
