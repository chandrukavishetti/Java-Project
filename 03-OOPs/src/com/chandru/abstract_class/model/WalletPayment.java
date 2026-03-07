package com.chandru.abstract_class.model;

public class WalletPayment extends Payment {
	private String walletName;

	public WalletPayment(double amount, String walletName) {
		super(amount);
		this.walletName = walletName;
	}

	@Override
	public void processPayment() {
		if (validateAmount()) {

			double fee = amount * 0.01;
			double total = amount + fee;

			System.out.println("processing wallet payment ");
			System.out.println("wallet name : " + walletName);
			System.out.println("processing fee (1%) : " + fee);
			System.out.println("Total amount deducted : " + total);
		}
	}

}
