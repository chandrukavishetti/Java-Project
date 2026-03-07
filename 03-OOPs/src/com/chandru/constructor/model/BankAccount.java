package com.chandru.constructor.model;

public class BankAccount {

	private static int idCounter = 1000;
	private static final double interest;

	static {
		interest = 0.05;
	}

	private final int accountNumber;
	private String accountHolderName;
	protected double balance;

	public BankAccount(String accountHolderName) {
		this(accountHolderName, 0);
	}

	public BankAccount(String accountHolderName, double balance) {

		if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
			System.out.println("Invalid account holder name");
		}

		if (balance < 0) {
			System.out.println("Enter the positve amount");
		}

		this.accountNumber = ++idCounter;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public static double getInterestRate() {
		return interest;
	}
}
