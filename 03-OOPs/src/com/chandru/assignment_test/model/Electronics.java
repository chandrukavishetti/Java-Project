package com.chandru.assignment_test.model;

public class Electronics extends Product {

	private String electronicProdName;

	public Electronics(int id, String productName, double basePrice, String electronicProdName) {

		super(id, productName, basePrice);
		ProductValidator.productNameValidator(electronicProdName);

		this.electronicProdName = electronicProdName;
	}

	@Override
	public void displayProduct() {

		System.out.println("\nElectronics Product");
		System.out.println("ID: " + getProductId());
		System.out.println("Product Name: " + getProductName());
		System.out.println("Base Price: " + getProductPrice());
		System.out.println("Electronic Type: " + electronicProdName);
	}
}