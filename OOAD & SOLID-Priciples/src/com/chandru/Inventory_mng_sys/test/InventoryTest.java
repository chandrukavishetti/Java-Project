package com.chandru.Inventory_mng_sys.test;

import java.util.*;
import com.chandru.Inventory_mng_sys.model.*;

public class InventoryTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();

		List<Notifier> notifiers = new ArrayList<>();
		notifiers.add(new EmailNotifier());
		notifiers.add(new SMSNotifier());

		ReorderService reorderService = new ReorderService(notifiers);
		InventoryService service = new InventoryService(reorderService);

		while (true) {
			System.out.println("\n1. Add Product\n2. Add Stock\n3. Remove Stock\n4. Show all stocks\n5. Exit");

			int choice = input.getInt("Enter choice: ");

			switch (choice) {

			case 1:
				String name = input.getString("Name: ");
				int qty = input.getInt("Qty: ");
				double price = input.getDouble("Price: ");
				int reorder = input.getInt("Reorder level: ");

				service.addProduct(new Product(name, qty, price, reorder));
				break;

			case 2:
				name = input.getString("Name: ");
				qty = input.getInt("Qty: ");
				service.addStock(name, qty);
				break;

			case 3:
				name = input.getString("Name: ");
				qty = input.getInt("Qty: ");
				service.removeStock(name, qty);
				break;

			case 4:
				service.showProducts();

				double value = service.calculateValue(new Valuation());
				System.out.println("Total amount is : " + value);
				break;

			case 5:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}