package com.chandru.Stream_API_Student_Result.model;

import java.util.Scanner;

public class InputHandler {
	private final Scanner scanner = new Scanner(System.in);

	public String getString(String prompt) {
		System.out.print(prompt);
		String val = scanner.nextLine().trim();
		if (val.isEmpty() || !val.matches("^[a-zA-Z\\s]+$")) {
			System.out.println("Invalid input! Please use letters only (no numbers or symbols).");
			return getString(prompt);
		}
		return val;
	}

	public int getInt(String prompt) {
		System.out.print(prompt);
		try {
			int val = Integer.parseInt(scanner.nextLine());
			if (val < 0) {
				System.out.println("Value cannot be negative. Please try again.");
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
				System.out.println("Value cannot be negative. Please try again.");
				return getDouble(prompt);
			}
			return val;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! Please enter a decimal or whole number.");
			return getDouble(prompt);
		}
	}

	public boolean getBoolean(String prompt) {
		System.out.println(prompt + ":");
		System.out.println("1. True (Active)");
		System.out.println("2. False (Inactive)");
		System.out.print("Enter choice (1 or 2): ");

		String choice = scanner.nextLine();
		if (choice.equals("1")) {
			return true;
		} else if (choice.equals("2")) {
			return false;
		} else {
			System.out.println("Invalid selection! Please press 1 or 2 only.");
			return getBoolean(prompt);
		}
	}
}