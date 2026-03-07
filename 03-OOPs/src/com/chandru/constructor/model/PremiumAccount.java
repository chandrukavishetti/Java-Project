package com.chandru.constructor.model;

public class PremiumAccount extends BankAccount {

	private static final double BONUS_AMOUNT = 1000;

	public PremiumAccount(String accountHolderName, double balance) {

		super(accountHolderName, balance); 

		this.balance += BONUS_AMOUNT;
	}
}
