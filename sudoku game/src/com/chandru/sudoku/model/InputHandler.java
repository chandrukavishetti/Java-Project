package com.chandru.sudoku.model;

import java.util.Scanner;

public class InputHandler {

	private Scanner scanner;

	public InputHandler() {
		scanner = new Scanner(System.in);
	}

	public int readRow() throws InvalidInputException {
		System.out.print("Enter row (1-9): ");

		if (!scanner.hasNextInt()) {
			String invalidInput = scanner.next();
			throw new InvalidInputException("'" + invalidInput + "' is not a number");
		}

		int row = scanner.nextInt();

		if (row < 1 || row > 9) {
			throw new InvalidInputException("Row must be between 1 and 9");
		}

		return row - 1;
	}

	public int readColumn() throws InvalidInputException {

		System.out.print("Enter column (1-9): ");

		if (!scanner.hasNextInt()) {

			String invalidInput = scanner.next();
			throw new InvalidInputException("'" + invalidInput + "' is not a number");
		}

		int col = scanner.nextInt();

		if (col < 1 || col > 9) {
			throw new InvalidInputException("Column must be between 1 and 9");
		}

		return col - 1;
	}

	public int readNumber() throws InvalidInputException {

		System.out.print("Enter number (1-9): ");

		if (!scanner.hasNextInt()) {

			String invalidInput = scanner.next();
			throw new InvalidInputException("'" + invalidInput + "' is not a number");
		}

		int num = scanner.nextInt();

		if (num < 1 || num > 9) {
			throw new InvalidInputException("Number must be between 1 and 9");
		}

		return num;
	}

	public int readMenuChoice(int min, int max) throws InvalidInputException {

		if (!scanner.hasNextInt()) {
			String invalid = scanner.next();
			throw new InvalidInputException("'" + invalid + "' is not a valid number.");
		}

		int choice = scanner.nextInt();

		if (choice < min || choice > max) {
			throw new InvalidInputException("Please enter a choice between " + min + " and " + max + ".");
		}

		return choice;
	}
}