package com.chandru.assignment_test.model;

import java.util.Scanner;

public class ProductInputHandler {

	private Scanner scanner = new Scanner(System.in);

	public int getInt(String message) {

		while (true) {

			try {
				System.out.print(message);
				int input=Integer.parseInt(scanner.nextLine());
				
				ProductValidator.productIdValidator(input);
				return input;
			} catch (NumberFormatException e) {
				System.out.println("Invalid number. Try again.");
			}catch(IllegalArgumentException e) {
				System.out.println("error : "+e.getMessage());
			}
		}
	}

	public double getDouble(String message) {

		while (true) {

			try {
				System.out.print(message);
				double inputDouble= Double.parseDouble(scanner.nextLine());
				ProductValidator.productPriceValidator(inputDouble);
				return inputDouble;
			} catch (NumberFormatException e) {
				System.out.println("Invalid price. Try again.");
			}
		}
	}

	public String getString(String message) {

		while (true) {

			System.out.print(message);
			String input = scanner.nextLine();
			ProductValidator.productNameValidator(input);
			
			if (!input.trim().isEmpty()) {
				return input;
			}

			System.out.println("Input cannot be empty");
		}
	}
}