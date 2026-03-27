package com.chandru.Stream_API_Assignment_Skip;

import java.util.Arrays;
import java.util.List;

class Product {
	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}

public class Above500SkipTwo {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(objectInitialization("washingmachine", 25000),
				objectInitialization("AirConditioner", 35000), objectInitialization("cooler", 12000),
				objectInitialization("fan", 1000), objectInitialization("table fan ", 200));
		products.stream().filter(p -> p.getPrice() > 500).skip(2).forEach(p -> System.out
				.println("| Product name : " + p.getName() + "  |  Product price : " + p.getPrice() + " |"));
	}

	public static Product objectInitialization(String name, int price) {
		return new Product(name, price);
	}

}
