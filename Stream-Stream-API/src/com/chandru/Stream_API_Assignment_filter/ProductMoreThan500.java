package com.chandru.Stream_API_Assignment_filter;

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

public class ProductMoreThan500 {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product("laptop", 50000), new Product("mouse", 300),
				new Product("monitor", 2000), new Product("keyboard", 450), new Product("battery", 3500));
		System.out.println("product price who have the more than 500 RS");

		products.stream().filter(product -> product.getPrice() > 500)
				.forEach(product -> System.out.println("[" + product.getName() + "-" + product.getPrice() + "]"));
	}

}
