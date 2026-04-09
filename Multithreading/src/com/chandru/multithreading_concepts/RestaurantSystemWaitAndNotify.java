package com.chandru.multithreading_concepts;

import java.util.LinkedList;
import java.util.Queue;

class KitchenCounter {
	private Queue<String> dishes = new LinkedList<>();
	private final int max_capacity = 3;

	public synchronized void cookDish(String dish) throws InterruptedException {
		while (dishes.size() == max_capacity) {
			System.out.println("counter ful chef waits");
			wait();
		}
		dishes.add(dish);
		System.out.println("chef cooked : " + dish + " | counter : " + dishes);
		notifyAll();
	}

	public synchronized String takeDish() throws InterruptedException {
		while (dishes.isEmpty()) {
			System.out.println("counter empty waiter waits..");
			wait();
		}
		String dish = dishes.poll();
		System.out.println("waiter served : " + dish);
		notifyAll();
		return dish;
	}
}

public class RestaurantSystemWaitAndNotify {
	public static void main(String[] args) {
		KitchenCounter counter = new KitchenCounter();
		String[] menu = { "vegbiriyani", "Dosa", "Curry", "Naam", "Sambar" };

		// chef thread (producer)
		Thread chef = new Thread(() -> {
			for (String dish : menu) {
				try {
					counter.cookDish(dish);
					Thread.sleep(300);

				} catch (InterruptedException e) {
					break;
				}
			}
		}, "chef");

		Thread waiter = new Thread(() -> {
			for (int i = 0; i < menu.length; i++) {
				try {
					counter.takeDish();
					Thread.sleep(600);
				} catch (InterruptedException e) {
					break;
				}
			}
		}, "Waiter");
		chef.start();
		waiter.start();
	}
}
