package com.chandru.sudoku.model;

public class Menu {

	private InputHandler inputHandler;

	public Menu() {

		this.inputHandler = new InputHandler();
	}

	public int chooseDifficulty() {
		while (true) {
			try {
				System.out.println("==== Sudoku Game ====");
				System.out.println("1. Easy (60 filled)");
				System.out.println("2. Medium (40 filled)");
				System.out.println("3. Hard (20 filled)");
				System.out.print("Choose option: ");
				return inputHandler.readMenuChoice(1, 3);
			} catch (InvalidInputException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}