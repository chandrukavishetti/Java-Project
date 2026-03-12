package com.chandru.numberGuesserGame;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class RandomNumberGuesserGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
		int i = 1;
		int maxChances = 5;

		System.out.println("Welcome! You have " + maxChances + " chances to guess the number.");

		while (i <= maxChances) {
			System.out.print("\nChance " + i + " - Guess a number (1 to 100): ");

			if (!scanner.hasNextInt()) {
				String invalidInput = scanner.next();
				System.out.println("Invalid input: '" + invalidInput + "'. Please enter numbers only!");
				continue;
			}

			int userInput = scanner.nextInt();

			if (userInput < 1 || userInput > 100) {
				System.out.println("Warning: Your guess is outside the range (1-100).");
			}

			if (userInput == randomNum) {
				System.out.println("You guessed the number correctly! Congrats!");
				break;
			} else if (userInput < randomNum) {
				System.out.println("Hint: Too small!");
			} else {
				System.out.println("Hint: Too big!");
			}

			i++;
		}

		if (i > maxChances) {
			System.out.println("\nGame Over! You've used all your chances.");
		}

		System.out.println("The random number was: " + randomNum);
		scanner.close();
	}
}
