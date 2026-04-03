package com.chandru.Stream_API_Hospital_Patient.model;

import java.util.Scanner;

public class InputHandler {
	private final Scanner scanner = new Scanner(System.in);

	// Ensures only alphabets and spaces are allowed for names
	public String getString(String prompt) {
		System.out.print(prompt);
		String val = scanner.nextLine().trim();
		// Regex: ^[a-zA-Z\\s]+$ means only letters and spaces allowed
		if (val.isEmpty() || !val.matches("^[a-zA-Z\\s]+$")) {
			System.out.println("Invalid input! Please enter alphabets only (no numbers or symbols).");
			return getString(prompt);
		}
		return val;
	}

	// New method specifically for Category (Only 1 or 2)
	public int getCategory(String prompt) {
		System.out.println(prompt);
		System.out.println("1. Veg");
		System.out.println("2. Non-Veg");
		System.out.print("Enter choice (1 or 2): ");

		try {
			int val = Integer.parseInt(scanner.nextLine());
			if (val == 1 || val == 2) {
				return val;
			} else {
				System.out.println("Invalid choice! Please enter either 1 or 2.");
				return getCategory(prompt);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! Please enter a number (1 or 2).");
			return getCategory(prompt);
		}
	}

	public int getInt(String prompt) {
		System.out.print(prompt);
		try {
			int val = Integer.parseInt(scanner.nextLine());
			if (val < 0) {
				System.out.println("Value cannot be negative.");
				return getInt(prompt);
			}
			return val;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! Please enter a whole number.");
			return getInt(prompt);
		}
	}

	public double getDouble(String prompt) {
		System.out.print(prompt);
		try {
			double val = Double.parseDouble(scanner.nextLine());
			if (val < 0) {
				System.out.println("Price cannot be negative.");
				return getDouble(prompt);
			}
			return val;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! Please enter a numeric price.");
			return getDouble(prompt);
		}
	}

	public boolean getBoolean(String prompt) {
		System.out.println(prompt + ":");
		System.out.println("1. yes");
		System.out.println("2. no");
		System.out.print("Enter choice (1 or 2): ");

		String choice = scanner.nextLine();
		if (choice.equals("1"))
			return true;
		if (choice.equals("2"))
			return false;

		System.out.println("Invalid selection! Please press 1 or 2.");
		return getBoolean(prompt);
	}
}