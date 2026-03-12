package com.chandru.PigDiceGame.model;

import java.util.Scanner;

public class InputHandler {

	private Scanner scanner;

	public InputHandler() {
		scanner = new Scanner(System.in);
	}

	public char getChoice() {

		System.out.print("Roll or hold? (r/h): ");
		String input = scanner.next().toLowerCase();

		char choice = input.charAt(0);

		if (input.length() != 1 || (choice != 'r' && choice != 'h')) {
			System.out.println("Invalid input! Please enter only 'r' to roll or 'h' to hold.");
			return getChoice();
		}

		return choice;
	}

	public void close() {
		scanner.close();
	}
}