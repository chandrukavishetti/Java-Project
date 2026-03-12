package com.chandru.pigDiceGame;

import java.util.Scanner;
import java.util.Random;

public class PigDiceGame {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int totalScore = 0;
		int turn = 0;

		System.out.println("Let's Play PIG!");
		System.out.println("Reach 20 points to win.\n");

		while (totalScore < 20) {

			turn++;
			int turnScore = 0;
			boolean turnOver = false;

			System.out.println("TURN " + turn);

			while (!turnOver) {
				System.out.print("Roll or hold? (r/h): ");
				String input = scanner.next().toLowerCase();
				char choice = input.charAt(0);

				if (input.length() != 1 || (choice != 'r' && choice != 'h')) {
					System.out.println("Invalid input! Please enter only 'r' to roll or 'h' to hold.");
					continue;
				}

				if (choice == 'r') {
					int dice = random.nextInt(6) + 1;
					System.out.println("Die: " + dice);

					if (dice == 1) {
						System.out.println("Turn over. No score.\n");
						turnScore = 0;
						turnOver = true;
					} else {
						turnScore += dice;

						System.out.println("Current turn score: " + turnScore);

						if (totalScore + turnScore >= 20) {
							System.out.println("You've reached the goal!");
							totalScore += turnScore;
							turnOver = true;
						}
					}

				} else if (choice == 'h') {
					totalScore += turnScore;
					System.out.println("Score for turn: " + turnScore);
					System.out.println("Total score: " + totalScore + "\n");
					turnOver = true;
				}
			}
		}

		System.out.println("You finished in " + turn + " turns!");
		System.out.println("Final Score: " + totalScore);
		System.out.println("Game over!");

		scanner.close();
	}
}
