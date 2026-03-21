package com.chandru.comparator_comparable_assignment.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.chandru.comparator_comparable_assignment.model.Product;

public class ProductSorterTest {

	public static class CategoryThenPriceComparator implements Comparator<Product> {
		@Override
		public int compare(Product p1, Product p2) {
			// First compare by category (A to Z)
			int categoryComparison = p1.getCategory().compareTo(p2.getCategory());

			if (categoryComparison != 0) {
				return categoryComparison;
			}

			// If same category, compare by price (ascending)
			return Double.compare(p1.getPrice(), p2.getPrice());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		int numberOfProducts = 0;

		System.out.println("=== Product Sorter ===");
		System.out.println("This program sorts products by category (A-Z) and then by price (lowest to highest)\n");

		while (true) {
			try {
				System.out.print("How many products do you want to enter? ");
				numberOfProducts = scanner.nextInt();

				if (numberOfProducts <= 0) {
					System.out.println("Error: Please enter a positive number.");
					continue;
				}

				scanner.nextLine();
				break;

			} catch (InputMismatchException e) {
				System.out.println("Error: Please enter a valid positive integer.");
				scanner.nextLine();
			}
		}

		System.out.println("\n--- Enter Product Details ---");

		for (int i = 0; i < numberOfProducts; i++) {
			System.out.println("\nProduct " + (i + 1) + ":");

			String category = "";
			while (true) {
				System.out.print("Enter Category (e.g., Electronics, Clothing, Books): ");
				category = scanner.nextLine().trim();

				if (category.isEmpty()) {
					System.out.println("Error: Category cannot be empty.");
				} else {
					break;
				}
			}

			String name = "";
			while (true) {
				System.out.print("Enter Product Name: ");
				name = scanner.nextLine().trim();

				if (name.isEmpty()) {
					System.out.println("Error: Product name cannot be empty.");
				} else {
					break;
				}
			}

			double price = 0;
			while (true) {
				try {
					System.out.print("Enter Price: $");
					price = scanner.nextDouble();

					if (price <= 0) {
						System.out.println("Error: Price must be greater than zero.");
						continue;
					}

					scanner.nextLine();
					break;

				} catch (InputMismatchException e) {
					System.out.println("Error: Please enter a valid number for price.");
					scanner.nextLine();
				}
			}

			products.add(new Product(category, name, price));
		}

		System.out.println("\n======================================");
		System.out.println("Original Product List (Before Sorting):");
		System.out.println("======================================");
		printProducts(products);

		Collections.sort(products, new CategoryThenPriceComparator());

		System.out.println("\n======================================");
		System.out.println("Sorted Product List (After Sorting by Category A-Z, then Price Low to High):");
		System.out.println("======================================");
		printProducts(products);

		scanner.close();
	}

	public static void printProducts(List<Product> products) {
		System.out.println("\nCategory\t\tProduct Name\t\t\tPrice");
		System.out.println("------------------------------------------------------------------------");
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			System.out.printf("%d. %-15s %-25s $%.2f\n", (i + 1), p.getCategory(), p.getName(), p.getPrice());
		}
	}
}