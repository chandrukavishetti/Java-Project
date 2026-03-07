package com.chandru.Interface.model;

public class SavingAccount implements AccountOperations {
	private double balance;

	public SavingAccount(double balance) {
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		System.out.println("amount deposited : " + amount);
	}

	@Override
	public void withdraw(double amount) {
		if (amount > 10000) {
			System.out.println("limint exceeds (max=10000 Rs)");
			return;
		}
		if (amount > balance) {
			System.out.println("insufficient balance");
			return;
		}
		balance -= amount;
		System.out.println("amount withdrawn is : " + amount);
	}

	@Override
	public void checkBalance() {
		System.out.println("savings account balance : " + balance);
	}

}
