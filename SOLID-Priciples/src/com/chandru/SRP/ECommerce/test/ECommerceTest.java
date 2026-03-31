package com.chandru.SRP.ECommerce.test;

import com.chandru.SRP.ECommerce.model.*;

public class ECommerceTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();

		int id = input.getInt("Enter Product ID: ");
		String name = input.getString("Enter Product Name: ");
		double price = input.getDouble("Enter Product Price: ");
		int quantity = input.getInt("Enter Stock Quantity: ");

		Product product = new Product(id, name, price, quantity);

		double discount = input.getDouble("Enter Discount (%): ");
		double tax = input.getDouble("Enter Tax (%): ");

		PriceCalculator calculator = new PriceCalculator();
		InventoryManager inventory = new InventoryManager();
		ProductPrinter printer = new ProductPrinter();

		double finalPrice = calculator.calculateFinalPrice(product, discount, tax);

		int reduceQty = input.getInt("Enter quantity to purchase: ");
		boolean success = inventory.reduceStock(product, reduceQty);

		if (!success) {
			System.out.println(" Not enough stock!");
		} else {
			System.out.println("Purchase successful!");
		}

		printer.printProduct(product, finalPrice);
	}
}