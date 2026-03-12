package com.chandru.numberGuesserGame.model;

public class NumberGuesserGame {

	private int randomNum;
	private int maxChances;
	private RandomNumberGenerator generator;
	private InputValidator input;

	public NumberGuesserGame() {
		generator = new RandomNumberGenerator();
		input = new InputValidator();
		randomNum = generator.generateNumber();
		maxChances = 5;
	}

	public void startGame() {

		int i = 1;

		System.out.println("Welcome! You have " + maxChances + " chances to guess the number.");

		while (i <= maxChances) {

			System.out.print("\nChance " + i + " - Guess a number (1 to 100): ");

			int userInput = input.getValidNumber();

			if (userInput < 1 || userInput > 100) {
				System.out.println("Warning: Your guess is outside the range (1-100).");
			}

			if (userInput == randomNum) {
				System.out.println("You guessed the number correctly! Congrats!");
				break;
			}

			if (userInput < randomNum) {
				System.out.println("Hint: Too small!");
			}

			if (userInput > randomNum) {
				System.out.println("Hint: Too big!");
			}

			i++;
		}

		if (i > maxChances) {
			System.out.println("\nGame Over! You've used all your chances.");
		}

		System.out.println("The random number was: " + randomNum);
		input.close();
	}
}