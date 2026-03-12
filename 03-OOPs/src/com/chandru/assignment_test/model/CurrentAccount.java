package com.chandru.assignment_test.model;

public class CurrentAccount extends Account {

	public CurrentAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public void displayAccountDetails() {

		System.out.println("\nCurrent Account");
		System.out.println("Account Number: " + getAccountNumber());
		System.out.println("Holder Name: " + getHolderName());
		System.out.println("Balance: " + getBalance());
	}
}