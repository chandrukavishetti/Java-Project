package com.chandru.tic_tac_toe_using_Facade.model;

import java.util.Scanner;

public class InputValidator {

	private final Scanner scanner;

	public InputValidator(Scanner scanner) {
		this.scanner = scanner;
	}

	public int getBoardSize() {
		while (true) {
			System.out.println("Choose Board Size (3 / 4 / 5): ");
			String input = scanner.nextLine();

			if (!input.matches("[345]")) {
				System.out.println("Invalid input! Only 3, 4 or 5 allowed.");
				continue;
			}

			return Integer.parseInt(input);
		}
	}

	public int getValidPosition(int maxPosition, MarkType currentMark) {

		while (true) {

			System.out.println("Player " + currentMark + ", Enter position (1 - " + maxPosition + "): ");

			String input = scanner.nextLine();

			// No alphabets, no decimals, no spaces
			if (!input.matches("^[1-9][0-9]*$")) {
				System.out.println("Only positive integers allowed. No alphabets or decimals.");
				continue;
			}

			int position = Integer.parseInt(input);

			if (position < 1 || position > maxPosition) {
				System.out.println("Position out of range!");
				continue;
			}

			return position;
		}
	}

	public int getGameMode() {

		while (true) {

			System.out.println("Select Game Mode:");
			System.out.println("1. Human vs Human");
			System.out.println("2. Human vs Computer");

			String input = scanner.nextLine();

			if (!input.matches("[12]")) {
				System.out.println("Invalid choice! Enter 1 or 2 only.");
				continue;
			}

			return Integer.parseInt(input);
		}
	}

	public String getReplayChoice() {

		while (true) {

			System.out.println("Do you want to play again? (yes/no): ");

			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
				return input.toLowerCase();
			}

			System.out.println("Invalid input! Only 'yes' or 'no' allowed (lowercase, no spaces).");
		}
	}
}