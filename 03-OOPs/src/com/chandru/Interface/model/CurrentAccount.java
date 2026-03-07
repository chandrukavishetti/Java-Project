package com.chandru.Interface.model;

public class CurrentAccount implements AccountOperations {
	private double balance;

	public CurrentAccount(double balance) {
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		System.out.println("amount deposited : " + amount);
	}

	@Override
	public void withdraw(double amount) {
		if (amount > balance + 5000) {
			System.out.println("overdraft limit exceeds");
			return;
		}
		balance -= amount;
		System.out.println("amount withdrawn is : " + amount);
	}

	@Override
	public void checkBalance() {
		System.out.println("current account balance : " + balance);
	}
}
