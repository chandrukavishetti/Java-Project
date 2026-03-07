package com.chandru.constructor.test;

import com.chandru.constructor.model.Product;
import com.chandru.constructor.model.Order;
import com.chandru.constructor.model.DiscountedOrder;
import java.util.Scanner;

public class OrderTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		double price;
		int stock;
		int quantity;
		double discount;

		while (true) {
			System.out.print("Enter Product Price: ");

			if (!scanner.hasNextDouble()) {
				System.out.println("Enter valid price.");
				scanner.next();
				continue;
			}

			price = scanner.nextDouble();

			if (price <= 0) {
				System.out.println("Price must be greater than 0.");
				continue;
			}

			break;
		}

		while (true) {
			System.out.print("Enter Stock Quantity: ");

			if (!scanner.hasNextInt()) {
				System.out.println("Enter valid stock.");
				scanner.next();
				continue;
			}

			stock = scanner.nextInt();

			if (stock < 0) {
				System.out.println("Stock cannot be negative.");
				continue;
			}

			break;
		}

		Product product = new Product(price, stock);

		while (true) {
			System.out.print("Enter Order Quantity: ");

			if (!scanner.hasNextInt()) {
				System.out.println("Enter valid quantity.");
				scanner.next();
				continue;
			}

			quantity = scanner.nextInt();

			if (quantity <= 0) {
				System.out.println("Quantity must be greater than 0.");
				continue;
			}

			break;
		}

		System.out.println("Choose Order Type:");
		System.out.println("1. Normal Order");
		System.out.println("2. Discounted Order");

		int choice = scanner.nextInt();

		if (choice == 1) {

			Order order = new Order(product, quantity);

			System.out.println("Order Created Successfully!");
			System.out.println("Order ID: " + order.getOrderId());
			System.out.println("Total Amount: " + order.getTotalAmount());

		} else {

			while (true) {
				System.out.print("Enter Discount Percentage: ");

				if (!scanner.hasNextDouble()) {
					System.out.println("Enter valid discount.");
					scanner.next();
					continue;
				}

				discount = scanner.nextDouble();

				if (discount < 0 || discount > 100) {
					System.out.println("Discount must be between 0 and 100.");
					continue;
				}

				break;
			}

			DiscountedOrder dOrder = new DiscountedOrder(product, quantity, discount);

			System.out.println("Discounted Order Created!");
			System.out.println("Order ID: " + dOrder.getOrderId());
			System.out.println("Total Amount after Discount: " + dOrder.getTotalAmount());
		}

		scanner.close();
	}
}
