package com.chandru.Interface.model;

public class LoanAccount implements AccountOperations {

	private double loanAmount;

	public LoanAccount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	@Override
	public void deposit(double amount) {
		System.out.println("deposit of amuont not allowed to loan account");
	}

	@Override
	public void withdraw(double amount) {
		if (amount > loanAmount) {
			System.out.println("exceeds loan limit");
			return;
		}
		loanAmount -= amount;
		System.out.println("loan amoutn withdrawan is : " + amount);
	}

	@Override
	public void checkBalance() {
		System.out.println("remaining loan amoutn is : " + loanAmount);
	}

}
