package com.chandru.collection.ordertestmodel2;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class OrderRepository {

	private Set<Order> orders = new TreeSet<>();

	public void addOrder(Order order) throws DuplicateOrderException {

		if (!orders.add(order)) {
			throw new DuplicateOrderException("Duplicate Order ID: " + order.getOrderId());
		}
	}

	public void displayOrders() {

		for (Order o : orders) {
			o.display();
		}
	}

	public void removeOrder(int id) {

		Iterator<Order> iterator = orders.iterator();

		while (iterator.hasNext()) {

			Order o = iterator.next();

			if (o.getOrderId() == id) {
				iterator.remove();
			}
		}
	}

	public Order findOrder(int id) {

		for (Order o : orders) {
			if (o.getOrderId() == id)
				return o;
		}
		return null;
	}
}