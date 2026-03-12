package com.chandru.numberGuesserGame.model;

import java.util.Scanner;

public class InputValidator {

	private Scanner scanner;

	public InputValidator() {
		scanner = new Scanner(System.in);
	}

	public int getValidNumber() {

		if (!scanner.hasNextInt()) {
			String invalidInput = scanner.next();
			System.out.println("Invalid input: '" + invalidInput + "'. Please enter numbers only!");
			System.out.print("please Enter : ");
			return getValidNumber();
		}

		return scanner.nextInt();
	}

	public void close() {
		scanner.close();
	}
}