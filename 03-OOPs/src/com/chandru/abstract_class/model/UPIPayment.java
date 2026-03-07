package com.chandru.abstract_class.model;

public class UPIPayment extends Payment {
	private String upiId;

	public UPIPayment(double amount, String upiId) {
		super(amount);
		this.upiId = upiId;
	}

	@Override
	public void processPayment() {
		if (validateAmount()) {

			System.out.println("processing UPI payment ");
			System.out.println(" UPI ID : " + upiId);
			System.out.println("No processing fee");
			System.out.println("Total amount deducted : " + amount);

		}
	}

}
