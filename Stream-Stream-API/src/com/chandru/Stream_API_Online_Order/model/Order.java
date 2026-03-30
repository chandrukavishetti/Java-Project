package com.chandru.Stream_API_Online_Order.model;

public class Order {
	private int orderId;
	private String customerName;
	private int category; // 1 for Veg, 2 for Non-Veg
	private double amount;
	private boolean completed; // Changed to boolean to match InputHandler

	public Order(int orderId, String customerName, int category, double amount, boolean completed) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.category = category;
		this.amount = amount;
		this.completed = completed;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getCategory() {
		return category;
	}

	public double getAmount() {
		return amount;
	}

	public boolean isCompleted() {
		return completed;
	}

	@Override
	public String toString() {
		return String.format("ID: %d | Name: %-10s | Category: %-7s | Amount: %.2f | Status: %s", orderId, customerName,
				(category == 1 ? "Veg" : "Non-Veg"), amount, (completed ? "Completed" : "Cancelled"));
	}
}