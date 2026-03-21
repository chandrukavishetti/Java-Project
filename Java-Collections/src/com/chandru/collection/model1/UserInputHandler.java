package com.chandru.collection.model1;

import java.util.Scanner;

public class UserInputHandler {

	private Scanner scanner;

	public UserInputHandler() {
		scanner = new Scanner(System.in);
	}

	public String readAuthor(String message) {
		while (true) {
			System.out.println(message);
			String name = scanner.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("Name cannot be empty.");
				continue;
			}

			boolean isValid = true;
			for (int i = 0; i < name.length(); i++) {

				if (Character.isDigit(name.charAt(i))) {
					isValid = false;
					break;
				}
			}

			if (isValid) {
				return name;
			} else {
				System.out.println("Error: Enter only alphabets (no digits allowed).");

			}
		}
	}

	public int readInt(String message) {

		while (true) {

			System.out.print(message);

			try {
				int value = Integer.parseInt(scanner.nextLine());

				if (value <= 0) {
					System.out.println("Value must be positive.");
					continue;
				}

				return value;

			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}
	}

	public String readString(String message) {

		while (true) {

			System.out.print(message);

			String value = scanner.nextLine();

			if (value == null || value.trim().isEmpty()) {
				System.out.println("Input cannot be empty.");
				continue;
			}

			return value;
		}
	}

	public int readBookType() {

		while (true) {

			System.out.println("\nSelect Book Type");
			System.out.println("1. Academic Book");
			System.out.println("2. Magazine");

			try {

				int choice = Integer.parseInt(scanner.nextLine());

				if (choice == 1 || choice == 2)
					return choice;

				System.out.println("Please select 1 or 2.");

			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Enter numeric choice.");
			}
		}
	}
}