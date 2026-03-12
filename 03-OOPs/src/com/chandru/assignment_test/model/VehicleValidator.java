package com.chandru.assignment_test.model;

public class VehicleValidator {

	public static void registrationValidator(int regNo) {
		if (regNo <= 0) {
			throw new IllegalArgumentException("Usage charge must be greater than zero");
		}

	}

	public static void ownerNameValidator(String name) {

		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Owner name cannot be empty");
		}

		if (!name.matches("[a-zA-Z\\s]+")) {
			throw new IllegalArgumentException("Owner name must contain only alphabets");
		}
	}

	public static void chargeValidator(double charge) {

		if (charge <= 0) {
			throw new IllegalArgumentException("Usage charge must be greater than zero");
		}
	}
}