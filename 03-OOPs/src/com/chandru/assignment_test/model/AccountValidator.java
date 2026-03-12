package com.chandru.assignment_test.model;

public class AccountValidator {

	public static void validateAccountNumber(int accNo) {

		if (accNo <= 0) {
			throw new IllegalArgumentException("Account Number must be a positive integer.");
		}
	}

	public static void validateName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}

		if (!name.matches("[a-zA-Z\\s]+")) {
			throw new IllegalArgumentException("Name must contain only letters (no numbers or symbols).");
		}
	}

	public static void validateBalance(double balance) {

		if (balance < 0) {
			throw new IllegalArgumentException("Balance cannot be negative.");
		}
	}
}