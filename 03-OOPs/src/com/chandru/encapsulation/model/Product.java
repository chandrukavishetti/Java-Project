package com.chandru.encapsulation.model;

public class Product {

	private static int idCounter = 1000;

	private final int productId;
	private String productName;
	private double price;
	private int stockQuantity;
	private boolean discontinued;

	public Product(String productName, double price, int stockQuantity) {

		if (productName == null || productName.trim().isEmpty()) {
			System.out.println("Invalid product name");
		}

		if (price < 0) {
			System.out.println("price cannot be neagative");
		}

		if (stockQuantity < 0) {
			System.out.println("stock cannot be negatice");
		}

		this.productId = ++idCounter;
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.discontinued = false;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void increaseStock(int quantity) {

		if (discontinued) {
			System.out.println("Cannot modify stock. Product is discontinued.");
			return;
		}

		if (quantity <= 0) {
			System.out.println("Stock increase must be positive.");
			return;
		}

		stockQuantity += quantity;
		System.out.println("Stock increased successfully.");
	}

	public void reduceStock(int quantity) {

		if (discontinued) {
			System.out.println("Cannot modify stock. Product is discontinued.");
			return;
		}

		if (quantity <= 0) {
			System.out.println("Stock reduction must be positive.");
			return;
		}

		if (quantity > stockQuantity) {
			System.out.println("Insufficient stock.");
			return;
		}

		stockQuantity -= quantity;
		System.out.println("Stock reduced successfully.");
	}

	public void updatePrice(double newPrice, boolean isAdmin) {

		if (!isAdmin) {
			System.out.println("Only admin can update price.");
			return;
		}

		if (newPrice < 0) {
			System.out.println("Price cannot be negative.");
			return;
		}

		this.price = newPrice;
		System.out.println("Price updated successfully.");
	}

	public void discontinueProduct() {
		this.discontinued = true;
		System.out.println("Product discontinued.");
	}
}
