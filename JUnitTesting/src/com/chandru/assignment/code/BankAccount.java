package com.chandru.assignment.code;

public class BankAccount {

	public int balance;

	public String deposit(int damt) {
		if (damt <= 0) {
			return "Invalid operation";
		}
		balance += damt;
		return "Valid operation";
	}

	public String withdraw(int wamt) {
		if (wamt <= 0) {
			return "Invalid operation";
		}
		if (wamt > balance) {
			return "Invalid operation";
		}
		balance -= wamt;
		return "Valid operation";
	}

	public int getBalance() {
		return balance;
	}
}