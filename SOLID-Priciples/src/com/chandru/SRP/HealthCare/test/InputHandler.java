package com.chandru.SRP.HealthCare.test;

import java.util.Scanner;

public class InputHandler {
	private Scanner scanner = new Scanner(System.in);

	public int getInt(String message) {
		while (true) {
			try {
				System.out.print(message);
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid input! Enter a valid integer.");
			}
		}
	}

	public double getDouble(String message) {
		while (true) {
			try {
				System.out.print(message);
				return Double.parseDouble(scanner.nextLine());
			} catch (Exception e) {
				System.out.println(" Invalid input! Enter a valid number.");
			}
		}
	}

	public String getString(String message) {
		while (true) {
			System.out.print(message);
			String input = scanner.nextLine().trim();
			if (!input.isEmpty())
				return input;
			System.out.println("Input cannot be empty!");
		}
	}
}