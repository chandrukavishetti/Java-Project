package com.chandru.collection.model2;

public class OrderValidator {

	public static void validate(int id, String name, double amount) throws InvalidOrderDataException {

		if (id <= 0)
			throw new InvalidOrderDataException("Order ID must be positive");

		if (name == null || name.trim().isEmpty())
			throw new InvalidOrderDataException("Customer name cannot be empty");

		if (amount <= 0)
			throw new InvalidOrderDataException("Amount must be positive");
	}
}