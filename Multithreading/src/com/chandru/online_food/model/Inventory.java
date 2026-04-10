package com.chandru.online_food.model;

public class Inventory {

	private int pizza = 5;
	private int burger = 10;

	// synchronized method
	public synchronized boolean orderItem(String item) {

		if (item.equalsIgnoreCase("pizza")) {
			if (pizza > 0) {
				pizza--;
				System.out.println("Pizza remaining: " + pizza);
				return true;
			} else {
				return false;
			}
		}

		if (item.equalsIgnoreCase("burger")) {
			if (burger > 0) {
				burger--;
				System.out.println("Burger remaining: " + burger);
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
}