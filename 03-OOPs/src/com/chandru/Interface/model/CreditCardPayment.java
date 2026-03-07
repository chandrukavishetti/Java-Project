package com.chandru.Interface.model;

public class CreditCardPayment implements Payment {
	@Override
	public void processPayment(double amount) {
		System.out.println("processing");
		System.out.println("amount paid : " + amount);
		System.out.println("payment successful");
	}
}
