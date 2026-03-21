package com.chandru.collection.model2;

import java.util.LinkedList;
import java.util.Queue;

public class DispatchQueueManager {

	private Queue<Order> queue = new LinkedList<>();

	public void addToQueue(Order order) {
		queue.add(order);
	}

	public void processOrder() {

		if (queue.isEmpty()) {
			System.out.println("No orders to dispatch");
			return;
		}

		Order o = queue.poll();

		System.out.println("Dispatching Order: " + o.getOrderId());
	}

	public void displayQueue() {

		for (Order o : queue) {
			System.out.println(o.getOrderId() + " - " + o.getCustomerName());
		}
	}
}