package com.chandru.collection.test2;

import com.chandru.collection.model2.*;

public class OrderTest {

	public static void main(String[] args) {

		OrderRepository repo = new OrderRepository();
		DispatchQueueManager queue = new DispatchQueueManager();
		CustomerOrderMap map = new CustomerOrderMap();
		UserInputHandler input = new UserInputHandler();

		int numberOfOrders = input.readInt("How many orders do you want to enter? ");

		for (int i = 1; i <= numberOfOrders; i++) {
			System.out.println("\n--- Entering Details for Order #" + i + " ---");

			try {
				int id = input.readInt("Enter Order ID: ");
				String name = input.readString("Enter Customer Name: ");
				double amount = input.readDouble("Enter Amount: ");
				int type = input.readOrderType();

				OrderValidator.validate(id, name, amount);

				Order order = createOrder(type, id, name, amount);

				repo.addOrder(order);
				map.addOrder(order);
				queue.addToQueue(order);

				System.out.println("Order #" + id + " added successfully.");

			} catch (Exception e) {

				System.out.println("Error processing order: " + e.getMessage());
			}
		}

		System.out.println("\n===============================");
		System.out.println("Final Order Summary");
		System.out.println("===============================");

		System.out.println("\nAll Orders (Repository):");
		repo.displayOrders();

		System.out.println("\nCustomer Mapping:");
		map.display();

		System.out.println("\nDispatch Queue Status:");
		queue.displayQueue();

		System.out.println("\nProcessing next order in queue...");
		queue.processOrder();
	}

	private static Order createOrder(int type, int id, String name, double amount) {
		if (type == 1)
			return new RegularOrder(id, name, amount);

		return new PriorityOrder(id, name, amount);
	}
}