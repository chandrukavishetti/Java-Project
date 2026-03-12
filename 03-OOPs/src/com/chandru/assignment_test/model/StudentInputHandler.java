package com.chandru.assignment_test.model;

import java.util.Scanner;

public class StudentInputHandler {

	private Scanner scanner = new Scanner(System.in);

	public int getInt(String message) {

		while (true) {

			try {
				System.out.print(message);
				int inputId = Integer.parseInt(scanner.nextLine());
				StudentValidator.validateId(inputId);
				return inputId;
			} catch (NumberFormatException e) {
				System.out.println("Invalid number. Try again.");
			}catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	public double getDouble(String message) {

		while (true) {

			try {
				System.out.print(message);
				double inputDouble = Double.parseDouble(scanner.nextLine());
				StudentValidator.validateScholarship(inputDouble);
				return inputDouble;
			} catch (NumberFormatException e) {
				System.out.println("Invalid amount. Try again.");
			}
		}
	}

	public String getString(String message) {
		while (true) {
			try {
				System.out.print(message);

				String inputString = scanner.nextLine().trim();

				if (inputString.isEmpty()) {
					System.out.println("Input cannot be empty.");
					continue;
				}

				StudentValidator.validateName(inputString);

				return inputString;

			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}