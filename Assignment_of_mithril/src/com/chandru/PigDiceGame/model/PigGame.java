package com.chandru.PigDiceGame.model;

public class PigGame {

	private int totalScore;
	private int turn;
	private Dice dice;
	private InputHandler input;

	public PigGame() {
		totalScore = 0;
		turn = 0;
		dice = new Dice();
		input = new InputHandler();
	}

	public void startGame() {

		System.out.println("Let's Play PIG!");
		System.out.println("Reach 20 points to win.\n");

		while (totalScore < 20) {

			turn++;
			int turnScore = 0;
			boolean turnOver = false;

			System.out.println("TURN " + turn);

			while (!turnOver) {

				char choice = input.getChoice();

				if (choice == 'r') {

					int diceValue = dice.roll();
					System.out.println("Die: " + diceValue);

					if (diceValue == 1) {
						System.out.println("Turn over. No score.\n");
						turnScore = 0;
						turnOver = true;
					}

					if (diceValue != 1) {

						turnScore += diceValue;
						System.out.println("Current turn score: " + turnScore);

						if (totalScore + turnScore >= 20) {
							System.out.println("You've reached the goal!");
							totalScore += turnScore;
							turnOver = true;
						}
					}
				}

				if (choice == 'h') {
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

		input.close();
	}
}