package com.chandru.Stream_API_Product_Inventory.test;

import java.util.*;

import com.chandru.Stream_API_Product_Inventory.model.*;

public class ProductTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();
		ProductService service = new ProductService();

		List<Product> list = new ArrayList<>();

		int n = input.getInt("Enter number of products: ");

		for (int i = 0; i < n; i++) {
			System.out.println("\n--- Enter Product " + (i + 1) + " Details ---");

			int id = input.getInt("ID: ");
			String name = input.getString("Name: ");
			String category = input.getString("Category: ");
			double price = input.getDouble("Price: ");
			int stock = input.getInt("Stock: ");
			int sold = input.getInt("Sold Units: ");

			list.add(new Product(id, name, category, price, stock, sold));
		}

		// 1
		System.out.println("\n--- Out of Stock Products ---");
		service.getOutOfStockProducts(list).forEach(System.out::println);

		// 2
		System.out.println("\n--- Group By Category ---");
		System.out.println(service.getGroupByCategory(list));

		// 3
		System.out.println("\n--- Total Stock Value ---");
		System.out.println(service.getTotalStockValue(list));

		// 4
		System.out.println("\n--- Highest Sold Product ---");
		service.getHighestSoldUnit(list).ifPresent(System.out::println);

		// 5
		System.out.println("\n--- Sorted by Sold Units ---");
		service.getSortedBySoldUnits(list).forEach(System.out::println);

		// 6
		System.out.println("\n--- Product Name -> Stock ---");
		System.out.println(service.getNameWithStock(list));

		// 7
		System.out.println("\nAll products have stock > 0 ? " + service.allProductsInStock(list));
	}
}