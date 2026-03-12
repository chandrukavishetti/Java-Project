package com.chandru.assignment_test.model;

public class Clothings extends Product {

	private String clothingBrandName;

	public Clothings(int id, String productName, double basePrice, String clothingBrandName) {

		super(id, productName, basePrice);
		ProductValidator.productNameValidator(clothingBrandName);

		this.clothingBrandName = clothingBrandName;
	}

	@Override
	public void displayProduct() {

		System.out.println("\nClothing Product");
		System.out.println("ID: " + getProductId());
		System.out.println("Product Name: " + getProductName());
		System.out.println("Base Price: " + getProductPrice());
		System.out.println("Brand Name: " + clothingBrandName);
	}
}