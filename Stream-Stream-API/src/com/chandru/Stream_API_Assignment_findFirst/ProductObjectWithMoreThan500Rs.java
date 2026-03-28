package com.chandru.Stream_API_Assignment_findFirst;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

public class ProductObjectWithMoreThan500Rs {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(productList("RCB", 16660), productList("Rajastan", 15550),
				productList("chennai", 1000), productList("Mumbai", 11000), productList("kolkata", 400));
		Optional<Product> result = products.stream().filter(prod -> prod.getPrice() > 500).findFirst();

		if (result.isPresent()) {
			Product p = result.get();
			System.out.println("Product name is : " + p.getName() + " | Product Price is : " + p.getPrice());
		}
	}

	public static Product productList(String name, int price) {
		return new Product(name, price);
	}

}
