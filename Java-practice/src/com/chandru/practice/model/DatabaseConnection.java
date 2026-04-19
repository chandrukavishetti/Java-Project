package com.chandru.practice.model;

public class DatabaseConnection {
	// 1. Static variable to hold the one and only instance
	private static DatabaseConnection instance;

	// 2. Static counter to track calls to getInstance()
	private static int accessCount = 0;

	// 3. Private constructor: Prevents instantiation from other classes
	private DatabaseConnection() {
		System.out.println("New DatabaseConnection instance created!");
	}

	// 4. Static method to provide global access to the instance
	public static DatabaseConnection getInstance() {
		accessCount++;
		// Lazy initialization: create the object only when first needed
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public void connect() {
		System.out.println("Connected to Database");
	}

	public static int getAccessCount() {
		return accessCount;
	}
}