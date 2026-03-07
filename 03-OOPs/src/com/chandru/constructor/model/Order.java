package com.chandru.constructor.model;

public class Order {

	private static int idCounter = 500;

	protected final int orderId;
	protected Product product;
	protected int quantity;
	protected double totalAmount;

	public Order(Product product, int quantity) {

		if (product == null) {
			System.out.println("Invalid discount percentage");
		}

		if (quantity <= 0) {
			System.out.println("Quantity must be greater than 0");
		}

		this.orderId = ++idCounter;
		this.product = product;
		this.quantity = quantity;

		this.totalAmount = product.getPrice() * quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
}
