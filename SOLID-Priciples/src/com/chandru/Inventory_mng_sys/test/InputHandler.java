package com.chandru.Inventory_mng_sys.test;

import java.util.Scanner;

public class InputHandler {

	private Scanner sc = new Scanner(System.in);

	public int getInt(String msg) {
		while (true) {
			System.out.print(msg);
			String input = sc.nextLine();

			String sanitizedInput = input.replaceAll("\\s+", "");

			try {

				if (!sanitizedInput.matches("^[0-9]+$")) {
					throw new Exception("Contains invalid characters");
				}

				int number = Integer.parseInt(sanitizedInput);

				if (number <= 0) {
					System.out.println("Please enter a positive number greater than zero.");
				} else {
					return number;
				}
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a valid positive whole number.");
			}
		}
	}

	public double getDouble(String msg) {

		while (true) {
			System.out.print(msg);
			String input = sc.nextLine();

			String sanitizedInput = input.replaceAll("\\s+", "");

			try {
				if (!sanitizedInput.matches("^[0-9]+$")) {
					throw new Exception("Contains invalid characters");
				}

				double number = Double.parseDouble(sanitizedInput);

				if (number <= 0) {
					System.out.println("Please enter a positive number greater than zero.");
				} else {
					return number;
				}
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a valid positive whole number.");
			}
		}
	}

	public String getString(String msg) {
		String input = "";
		boolean isValid = false;

		while (!isValid) {
			System.out.print(msg);
			input = sc.nextLine().trim();

			if (input.matches("^[a-zA-Z]+$")) {
				isValid = true;
			} else {
				System.out.println("Invalid input. Please enter letters only (no numbers or special characters).");
			}
		}
		return input;
	}
}