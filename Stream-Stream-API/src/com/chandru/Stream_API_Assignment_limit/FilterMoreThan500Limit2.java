package com.chandru.Stream_API_Assignment_limit;

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

public class FilterMoreThan500Limit2 {
	public static void main(String[] args) {
		List<Product> list = Arrays.asList(ProductList("Email", 5000), ProductList("googleOne", 499),
				ProductList("Youtube", 560), ProductList("meta", 300), ProductList("spotify", 4000),
				ProductList("netflix", 200), ProductList("amazon", 8000));
		list.stream().filter(f -> f.getPrice() > 500).limit(2).forEach(
				p -> System.out.println("product name is : " + p.getName() + " |  product price is : " + p.getPrice()));
	}

	public static Product ProductList(String name, int price) {
		return new Product(name, price);
	}
}
