package com.chandru.assignment_test.model;

public class ProductRepository {

	private Product[] products;
	private int index = 0;

	public ProductRepository(int size) {
		products = new Product[size];
	}

	public void addProduct(Product product) {

		if (index < products.length) {
			products[index++] = product;
		} else {
			System.out.println("Storage Full");
		}
	}

	public Product[] getAllProducts() {
		return products;
	}
}