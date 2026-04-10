package com.chandru.online_food.model;

public class OrderProcessorThread extends Thread {

	private Order order;
	private Inventory inventory;

	public OrderProcessorThread(Order order, Inventory inventory) {
		this.order = order;
		this.inventory = inventory;
	}

	@Override
	public void run() {
		processOrder();
	}

	private void processOrder() {
		System.out.println("Processing Order-" + order.getOrderId() + " by " + Thread.currentThread().getName());

		boolean success = inventory.orderItem(order.getItem());

		if (!success) {
			System.out.println("Order-" + order.getOrderId() + " FAILED: Out of stock");
		}
	}
}