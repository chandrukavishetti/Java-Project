package com.chandru.abstract_class.model;

public class CreditCardPayment extends Payment {
	private String cardHolderName;
	public CreditCardPayment(double amount,String cardHolderName) {
		super(amount);
		this.cardHolderName=cardHolderName;
	}

	@Override
	public void processPayment() {
		if (validateAmount()) {

			double fee = amount * 0.02;
			double total = amount + fee;

			System.out.println("processing credit card payment ");
			System.out.println("card holder name : "+cardHolderName);
			System.out.println("Processing fee (2%) "+fee);
			System.out.println("Total amount deducted "+total);
		}
		
	}

}
