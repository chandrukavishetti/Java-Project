package com.chandru.assignment_test.model;

public class SavingsAccount extends Account {

	public SavingsAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public void displayAccountDetails() {

		System.out.println("\nSavings Account");
		System.out.println("Account Number: " + getAccountNumber());
		System.out.println("Holder Name: " + getHolderName());
		System.out.println("Balance: " + getBalance());
	}
}