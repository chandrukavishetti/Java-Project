package com.chandru.abstract_class.model;

public abstract class Payment {
	protected double amount;

	public Payment(double amount) {
		this.amount = amount;
	}

	public boolean validateAmount() {
		if(amount>0) {
			return true;
		}
		System.out.println("Invalid amount must be greater than 0");
		return false;
	}

	public abstract void processPayment();

	public void generateReceipt() {
		System.out.println("payment successful");
		System.out.println("Paid amount is : " + amount);
		System.out.println("=============");
	}

}
