package com.chandru.assignment_test.model;

public abstract class Account {

	private int accountNumber;
	private String holderName;
	private double balance;

	public Account(int accountNumber, String holderName, double balance) {

		AccountValidator.validateAccountNumber(accountNumber);
		AccountValidator.validateName(holderName);
		AccountValidator.validateBalance(balance);

		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		AccountValidator.validateBalance(balance);
		this.balance = balance;
	}

	public abstract void displayAccountDetails();
}