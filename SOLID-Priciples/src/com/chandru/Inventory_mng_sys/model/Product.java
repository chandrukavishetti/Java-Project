package com.chandru.Inventory_mng_sys.model;

public class Product {
	private String name;
	private int quantity;
	private double price;
	private int reorderLevel;

	public Product(String name, int quantity, double price, int reorderLevel) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.reorderLevel = reorderLevel;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void addStock(int qty) {
		quantity += qty;
	}

	public void removeStock(int qty) {
		quantity -= qty;
	}
}