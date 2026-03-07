package com.chandru.Interface.model;

public class DebitCardPayment implements Payment {
	@Override
	public void processPayment(double amount) {
		System.out.println("processing debitcard");
		System.out.println("amount paid : " + amount);
		System.out.println("payment successful");
	}

}
