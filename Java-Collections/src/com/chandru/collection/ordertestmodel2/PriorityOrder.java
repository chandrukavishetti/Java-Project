package com.chandru.collection.ordertestmodel2;

public class PriorityOrder extends Order {

	public PriorityOrder(int id, String name, double amount) {
		super(id, name, amount);
	}

	@Override
	public void display() {
		System.out.println(
				"Priority Order -> ID:" + getOrderId() + " Name:" + getCustomerName() + " Amount:" + getAmount());
	}
}