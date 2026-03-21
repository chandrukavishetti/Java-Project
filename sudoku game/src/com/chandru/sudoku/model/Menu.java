package com.chandru.sudoku.model;

public class Menu {

	private InputHandler inputHandler;

	public Menu() {
		// Initialize the handler which contains our scanner logic
		this.inputHandler = new InputHandler();
	}

	public int chooseDifficulty() {
		while (true) { // Loop until we get valid input
			try {
				System.out.println("==== Sudoku Game ====");
				System.out.println("1. Easy");
				System.out.println("2. Difficult");
				System.out.print("Choose option: ");

				// Use the handler to validate everything
				return inputHandler.readMenuChoice(1, 2);

			} catch (InvalidInputException e) {
				// This catches alphabets, negatives, and numbers like 5
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}