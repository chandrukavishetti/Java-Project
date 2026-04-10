package com.chandru.online_food.test;

import com.chandru.online_food.model.*;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Inventory inventory = new Inventory();

		// Daemon Thread
		LoggerService logger = new LoggerService();
		logger.setDaemon(true);
		logger.start();

		System.out.print("Enter number of orders (10-15): ");
		int n = scanner.nextInt();

		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= n; i++) {

			System.out.println("\nOrder " + i);

			System.out.print("Enter order type (VIP/Regular/Low): ");
			String type = scanner.next();

			System.out.print("Enter item (pizza/burger): ");
			String item = scanner.next();

			Order order = new Order(i, type, item);

			// Priority Handling
			if (i % 2 == 0) {
				Thread t = new OrderProcessorThread(order, inventory);

				if (type.equalsIgnoreCase("VIP"))
					t.setPriority(Thread.MAX_PRIORITY);
				else if (type.equalsIgnoreCase("Low"))
					t.setPriority(Thread.MIN_PRIORITY);
				else
					t.setPriority(Thread.NORM_PRIORITY);

				t.start();

			} else {
				Runnable task = new OrderProcessorRunnable(order, inventory);
				executor.submit(task);
			}
		}

		executor.shutdown();
		scanner.close();
	}
}