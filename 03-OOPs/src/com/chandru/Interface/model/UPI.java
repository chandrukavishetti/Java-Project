package com.chandru.Interface.model;

public class UPI implements PaymentGateway {

	@Override
	public void pay(double amount) {
		System.out.println("Processing UPI Payment of " + amount);
		System.out.println("Payment Successful via UPI.");
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunding " + amount + " via UPI.");
		System.out.println("Refund Successful.");
	}
}