package com.chandru.SRP.ECommerce.model;

public class ProductPrinter {

	public void printProduct(Product product, double finalPrice) {
		System.out.println("\n----- Product Details -----");
		System.out.println("ID: " + product.getId());
		System.out.println("Name: " + product.getName());
		System.out.println("Base Price: " + product.getPrice());
		System.out.println("Final Price: " + finalPrice);
		System.out.println("Stock: " + product.getQuantity());
	}
}