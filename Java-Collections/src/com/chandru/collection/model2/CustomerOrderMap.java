package com.chandru.collection.model2;

import java.util.*;

public class CustomerOrderMap {

	private Map<String, List<Order>> map = new HashMap<>();

	public void addOrder(Order order) {

		map.putIfAbsent(order.getCustomerName(), new ArrayList<>());

		map.get(order.getCustomerName()).add(order);
	}

	public void display() {

		for (String customer : map.keySet()) {

			System.out.println("\nCustomer: " + customer);

			for (Order o : map.get(customer)) {
				o.display();
			}
		}
	}
}