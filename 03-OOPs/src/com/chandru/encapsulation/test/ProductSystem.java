package com.chandru.encapsulation.test;

import java.util.Scanner;
import com.chandru.encapsulation.model.Product;

public class ProductSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String name;
		double price;
		int stock;

		// --- Product Name Validation (Alphabets and Spaces only) ---
		while (true) {
			System.out.print("Enter Product Name: ");
			name = scanner.nextLine().trim();

			if (name.isEmpty()) {
				System.out.println("Invalid name. Name cannot be blank.");
				continue;
			}

			boolean nameInvalid = false;
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				if (!Character.isLetter(ch) && ch != ' ') {
					nameInvalid = true;
					break;
				}
			}

			if (nameInvalid) {
				System.out.println("Invalid name. Only alphabets and spaces are allowed.");
				continue;
			}
			break;
		}

		// --- Price Validation (Strict Numeric, No Leading Zeros) ---
		while (true) {
			System.out.print("Enter Price: ");
			String input = scanner.next().trim();

			if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
				System.out.println("Invalid format. Numbers should not start with leading zeros.");
				continue;
			}

			boolean isNumeric = true;
			int dotCount = 0;
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '.') {
					dotCount++;
					continue;
				}
				if (!Character.isDigit(ch)) {
					isNumeric = false;
					break;
				}
			}

			if (!isNumeric || dotCount > 1) {
				System.out.println("Invalid input. Enter numeric value only.");
				continue;
			}

			price = Double.parseDouble(input);
			if (price < 0) {
				System.out.println("Price cannot be negative.");
				continue;
			}
			break;
		}

		// --- Stock Quantity Validation (Strict Integer, No Leading Zeros) ---
		while (true) {
			System.out.print("Enter Stock Quantity: ");
			String input = scanner.next().trim();

			if (input.length() > 1 && input.startsWith("0")) {
				System.out.println("Invalid format. Stock cannot start with a leading zero.");
				continue;
			}

			boolean isInteger = true;
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					isInteger = false;
					break;
				}
			}

			if (!isInteger) {
				System.out.println("Invalid input. Enter whole numbers only.");
				continue;
			}

			stock = Integer.parseInt(input);
			if (stock < 0) {
				System.out.println("Stock cannot be negative.");
				continue;
			}
			break;
		}

		Product product = new Product(name, price, stock);

		int choice;

		do {
			System.out.println("\n1. Increase Stock");
			System.out.println("2. Reduce Stock");
			System.out.println("3. Update Price (Admin)");
			System.out.println("4. Discontinue Product");
			System.out.println("5. View Product Details");
			System.out.println("6. Exit");
			System.out.print("Choose option: ");

			String choiceInput = scanner.next();
			boolean choiceValid = true;
			for (int i = 0; i < choiceInput.length(); i++) {
				if (!Character.isDigit(choiceInput.charAt(i))) {
					choiceValid = false;
					break;
				}
			}

			if (!choiceValid) {
				System.out.println("Invalid choice. Enter a number.");
				choice = 0;
				continue;
			}

			choice = Integer.parseInt(choiceInput);

			switch (choice) {

			case 1:
				System.out.print("Enter quantity: ");
				String incInput = scanner.next();
				boolean incValid = true;
				for (int i = 0; i < incInput.length(); i++) {
					if (!Character.isDigit(incInput.charAt(i))) { incValid = false; break; }
				}
				if (!incValid || (incInput.length() > 1 && incInput.startsWith("0"))) {
					System.out.println("Invalid quantity.");
					break;
				}
				product.increaseStock(Integer.parseInt(incInput));
				break;

			case 2:
				System.out.print("Enter quantity: ");
				String redInput = scanner.next();
				boolean redValid = true;
				for (int i = 0; i < redInput.length(); i++) {
					if (!Character.isDigit(redInput.charAt(i))) { redValid = false; break; }
				}
				if (!redValid || (redInput.length() > 1 && redInput.startsWith("0"))) {
					System.out.println("Invalid quantity.");
					break;
				}
				product.reduceStock(Integer.parseInt(redInput));
				break;

			case 3:
				System.out.print("Enter new price: ");
				String npInput = scanner.next();
				boolean npValid = true;
				int npDots = 0;
				for (int i = 0; i < npInput.length(); i++) {
					char ch = npInput.charAt(i);
					if (ch == '.') { npDots++; continue; }
					if (!Character.isDigit(ch)) { npValid = false; break; }
				}
				if (!npValid || npDots > 1 || (npInput.length() > 1 && npInput.startsWith("0") && !npInput.startsWith("0."))) {
					System.out.println("Invalid price.");
					break;
				}
				product.updatePrice(Double.parseDouble(npInput), true);
				break;

			case 4:
				product.discontinueProduct();
				break;

			case 5:
				System.out.println("Product ID: " + product.getProductId());
				System.out.println("Name: " + product.getProductName());
				System.out.println("Price: " + product.getPrice());
				System.out.println("Stock: " + product.getStockQuantity());
				System.out.println("Discontinued: " + product.isDiscontinued());
				break;

			case 6:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid option.");
			}

		} while (choice != 6);

		scanner.close();
	}
}