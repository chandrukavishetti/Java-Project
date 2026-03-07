package com.chandru.encapsulation.model;

public class BankAccount {

	private static int accountCounter = 1000;
	private final int accountNumber;
	private String accountHolderName;
	private double balance;

	public BankAccount(String accountHolderName, double initialDeposit) {

		this.accountNumber = ++accountCounter;

		setAccountHolderName(accountHolderName);

		if (initialDeposit >= 0) {
			this.balance = initialDeposit;
		} else {
			this.balance = 0;
			System.out.println("Invalid initial deposit. Balance set to 0.");
		}
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setAccountHolderName(String name) {
		if (name == null || name.trim().isEmpty()) {
			System.out.println("Invalid name");
		}
		this.accountHolderName = name;
	}

	public void deposit(double amount) {

		if (amount <= 0) {
			System.out.println("Deposit amount must be positive.");
			return;
		}

		balance += amount;
		System.out.println("Deposit successful.");
	}

	public void withdraw(double amount) {

		if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive.");
			return;
		}

		if (amount > balance) {
			System.out.println("Insufficient balance.");
			return;
		}

		balance -= amount;
		System.out.println("Withdrawal successful.");
	}

	private void calculateInterest() {
		balance += balance * 0.05;
	}
}
