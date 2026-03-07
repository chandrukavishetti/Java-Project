package com.chandru.Interface.model;

public class CreditCard implements PaymentGateway {

	@Override
	public void pay(double amount) {
		System.out.println("Processing Credit Card Payment of " + amount);
		System.out.println("Payment Successful via Credit Card.");
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunding " + amount + " to Credit Card.");
		System.out.println("Refund Successful.");
	}
}