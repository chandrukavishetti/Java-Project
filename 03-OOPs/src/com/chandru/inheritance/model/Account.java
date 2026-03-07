package com.chandru.inheritance.model;

public class Account {
	protected String accountNumber;
	protected String holderName;
	protected double balance;

	public Account(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount");
			return;
		}
		balance += amount;
		System.out.println("deposit successfully");
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("invalid withdrawal amount");
			return;
		}
		if (amount > balance) {
			System.out.println("insufficient balance");
			return;
		}
		balance -= amount;
		System.out.println("withdrawal successful");
	}

	public void displayDetails() {
		System.out.println("\nAccount Details:");
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Holder Name    : " + holderName);
		System.out.println("Balance        : " + balance);
	}

}
