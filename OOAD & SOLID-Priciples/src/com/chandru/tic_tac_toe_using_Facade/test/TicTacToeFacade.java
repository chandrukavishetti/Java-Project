package com.chandru.tic_tac_toe_using_Facade.test;

import java.util.Scanner;
import com.chandru.tic_tac_toe_using_Facade.model.Game;

public class TicTacToeFacade {

	private Scanner scanner;
	private Game game;

	public TicTacToeFacade() {
		scanner = new Scanner(System.in);
	}

	public void showWelcomeMessage() {
		System.out.println("=================================");
		System.out.println("   WELCOME TO TIC TAC TOE GAME   ");
		System.out.println("=================================");
	}

	private void initializeGame() {
		game = new Game(scanner);
	}

	public void startGame() {
		game.start();
	}

	public void closeResources() {
		scanner.close();
		System.out.println("Game Closed. Thank you for playing!");
	}

	// MAIN FACADE METHOD
	public void play() {
		showWelcomeMessage();

		String choice;

		do {
			initializeGame();
			startGame();

			System.out.println("Do you want to play again? (yes/no): ");
			choice = scanner.nextLine();

		} while (choice.equalsIgnoreCase("yes"));

		closeResources();
	}
}