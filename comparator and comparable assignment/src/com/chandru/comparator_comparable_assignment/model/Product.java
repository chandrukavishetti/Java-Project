package com.chandru.comparator_comparable_assignment.model;

public class Product {
	private String category;
	private String name;
	private double price;

	public Product(String category, String name, double price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return category + " - " + name + " ($" + price + ")";
	}
}