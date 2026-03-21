package com.chandru.collection.model2;

public class RegularOrder extends Order {

	public RegularOrder(int id, String name, double amount) {
		super(id, name, amount);
	}

	@Override
	public void display() {
		System.out.println(
				"Regular Order -> ID:" + getOrderId() + " Name:" + getCustomerName() + " Amount:" + getAmount());
	}
}