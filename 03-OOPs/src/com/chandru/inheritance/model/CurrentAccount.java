package com.chandru.inheritance.model;

public class CurrentAccount extends Account {

	private double overdraftLimit;

	public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
		super(accountNumber, holderName, balance);
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public void withdraw(double amount) {

		if (amount <= 0) {
			System.out.println("Invalid withdrawal amount.");
			return;
		}

		if (balance - amount < -overdraftLimit) {
			System.out.println("Overdraft limit exceeded.");
			return;
		}

		balance -= amount;
		System.out.println("Withdrawal successful (Overdraft allowed).");
	}
}
