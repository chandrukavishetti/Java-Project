package com.chandru.online_food.model;

public class Order {
	private int orderId;
	private String type; // VIP / Regular / Low
	private String item;

	public Order(int orderId, String type, String item) {
		this.orderId = orderId;
		this.type = type;
		this.item = item;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getType() {
		return type;
	}

	public String getItem() {
		return item;
	}
}