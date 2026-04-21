package com.chandru.assignment.code;

public class MultipleExceptionScenario {

	public double balance = 0;

	public double withdraw(double amount) throws InsufficientFundBalanceException, InvalidAmountException {

		if (amount <= 0) {
			throw new InvalidAmountException("Amount must be greater than zero");
		}

		if (amount > balance) {
			throw new InsufficientFundBalanceException("Insufficient balance");
		}

		balance -= amount;
		return balance;
	}
}