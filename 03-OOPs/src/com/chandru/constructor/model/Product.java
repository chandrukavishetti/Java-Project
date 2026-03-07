package com.chandru.constructor.model;

public class Product {
	    private static int idCounter = 100;

	    private final int productId;
	    private double price;
	    private int stockQuantity;


	    public Product(double price, int stockQuantity) {

	        if (price <= 0) {
	            System.out.println("Price must be greater than 0");
	        }

	        if (stockQuantity < 0) {
	            System.out.println("Stock cannot be negative");
	        }

	        this.productId = ++idCounter;
	        this.price = price;
	        this.stockQuantity = stockQuantity;
	    }

	    public int getProductId() {
	        return productId;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public int getStockQuantity() {
	        return stockQuantity;
	    }
	}

