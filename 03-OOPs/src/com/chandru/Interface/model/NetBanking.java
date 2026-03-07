package com.chandru.Interface.model;

public class NetBanking implements PaymentGateway {

	@Override
	public void pay(double amount) {
		System.out.println("Processing NetBanking Payment of " + amount);
		System.out.println("Payment Successful via NetBanking.");
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunding " + amount + " via NetBanking.");
		System.out.println("Refund Successful.");
	}
}