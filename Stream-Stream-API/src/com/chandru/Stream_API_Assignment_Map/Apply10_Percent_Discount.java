package com.chandru.Stream_API_Assignment_Map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
	private String name;
	private double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}

public class Apply10_Percent_Discount {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(initializing("Rolls Royce", 40000000),
				initializing("Range Rover", 10000000), initializing("Virtus", 1500000), initializing("BE6", 2500000),
				initializing("Fortuner", 5500000));
		List<Product> discountedCars = products.stream().map(prod -> new Product(prod.getName(), prod.getPrice() * 0.9))
				.collect(Collectors.toList());

		System.out.println("After applying the 10% discount to each car : ");
		discountedCars.forEach(prod -> System.out.println("[" + prod.getName() + " : " + prod.getPrice() + "]"));
	}

	public static Product initializing(String name, int price) {
		return new Product(name, price);
	}

}
