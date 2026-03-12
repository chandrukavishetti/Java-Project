package com.chandru.assignment_test.model;

import java.util.Scanner;

public class AccountInputHandler {

	private Scanner scanner = new Scanner(System.in);

	public int getInt(String message) {

		while (true) {

			try {
				System.out.print(message);
				
				int input=Integer.parseInt(scanner.nextLine());
				
				AccountValidator.validateAccountNumber(input);
				return input;

			} catch (NumberFormatException e) {
				System.out.println("Error: Please enter a valid numeric number.");
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
			}
		}

	public double getDouble(String message) {

		while (true) {

			try {
				System.out.print(message);
				double inputDouble= Double.parseDouble(scanner.nextLine());
				AccountValidator.validateBalance(inputDouble);
				return inputDouble;
			} catch (NumberFormatException e) {
				System.out.println("Invalid amount. Try again.");
			}
		}
	}

	public String getString(String message) {

		while (true) {

			System.out.print(message);
			String input = scanner.nextLine();
			AccountValidator.validateName(input);

			if (!input.trim().isEmpty()) {
				return input;
			}

			System.out.println("Input cannot be empty.");
		}
	}
}
