package com.chandru.SRP.ECommerce.model;

public class PriceCalculator {

	public double calculateFinalPrice(Product product, double discountPercent, double taxPercent) {

		double price = product.getPrice();

		double discount = price * (discountPercent / 100);
		double discountedPrice = price - discount;

		double tax = discountedPrice * (taxPercent / 100);

		return discountedPrice + tax;
	}
}