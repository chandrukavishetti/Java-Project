package com.chandru.Interface.model;

public class UPIPayment implements Payment {
	@Override
	public void processPayment(double amount) {
		System.out.println("processing the upi");
		System.out.println("amount paid : " + amount);
		System.out.println("payment succcessful");
	}

}
