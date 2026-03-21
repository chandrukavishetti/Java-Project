package com.chandru.practice.model;

public class BankAccount {
	private int accountNumber;
	private double balance;

	public BankAccount(int accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
		} else {
			System.out.println("insufficient balance");
		}
	}

}
