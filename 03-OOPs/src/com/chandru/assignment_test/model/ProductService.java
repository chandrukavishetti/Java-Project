package com.chandru.assignment_test.model;

public class ProductService {

	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public void addProduct(Product product) {
		repository.addProduct(product);
	}

	public void displayProducts() {

		Product[] list = repository.getAllProducts();

		for (Product p : list) {

			if (p != null) {
				p.displayProduct();
			}
		}
	}
}