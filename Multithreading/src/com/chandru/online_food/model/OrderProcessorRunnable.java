package com.chandru.online_food.model;

public class OrderProcessorRunnable implements Runnable {

	private Order order;
	private Inventory inventory;

	public OrderProcessorRunnable(Order order, Inventory inventory) {
		this.order = order;
		this.inventory = inventory;
	}

	@Override
	public void run() {
		System.out.println("Processing Order-" + order.getOrderId() + " by " + Thread.currentThread().getName());

		boolean success = inventory.orderItem(order.getItem());

		if (!success) {
			System.out.println("Order-" + order.getOrderId() + " FAILED: Out of stock");
		}
	}
}