package com.chandru.Stream_API_Product_Inventory.model;

public class Product {
	private int id;
	private String name;
	private String category;
	private double price;
	private int stock;
	private int soldunit;

	public Product(int id, String name, String category, double price, int stock, int soldunit) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.soldunit = soldunit;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public int getSoldUnit() {
		return soldunit;
	}

	@Override
	public String toString() {
		return "id : : " + id + " name : " + name + " category : " + category + " price : " + price + " stock : "
				+ stock + "  sold Units : " + soldunit;
	}

}
