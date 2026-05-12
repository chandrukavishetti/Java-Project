package com.chandru.collection.ordertestmodel2;

public abstract class Order implements Comparable<Order> {

	private int orderId;
	private String customerName;
	private double amount;

	public Order(int orderId, String customerName, double amount) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public int compareTo(Order o) {
		return Double.compare(this.amount, o.amount); // sort by amount
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			Order o = (Order) obj;
			return this.orderId == o.orderId;
		}
		return false;
	}

	public abstract void display();
}