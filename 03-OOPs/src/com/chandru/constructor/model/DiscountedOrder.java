package com.chandru.constructor.model;

public class DiscountedOrder extends Order {

	private double discountPercentage;

	public DiscountedOrder(Product product, int quantity, double discountPercentage) {

		super(product, quantity);

		if (discountPercentage < 0 || discountPercentage > 100) {
			System.out.println("Invalid discount percentage");
		}

		this.discountPercentage = discountPercentage;

		this.totalAmount = totalAmount - (totalAmount * discountPercentage / 100);
	}
}
