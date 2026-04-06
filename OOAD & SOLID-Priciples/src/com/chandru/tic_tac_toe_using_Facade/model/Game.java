package com.chandru.tic_tac_toe_using_Facade.model;

import java.util.Scanner;

public class Game {

	private final Board board;
	private final Player player1;
	private final Player player2;
	private final WinChecker winChecker;
	private final InputValidator validator;

	public Game(Scanner scanner) {

		validator = new InputValidator(scanner);

		int mode = validator.getGameMode();
		int size = validator.getBoardSize();

		board = new Board(size);
		winChecker = new WinChecker();

		player1 = new HumanPlayer(MarkType.X);

		if (mode == 1) {
			player2 = new HumanPlayer(MarkType.O);
		} else {
			player2 = new ComputerPlayer(MarkType.O);
		}
	}

	public void start() {

		Player currentPlayer = player1;
		int maxPosition = board.getSize() * board.getSize();

		while (true) {

			board.displayBoard();

			int position = currentPlayer.choosePosition(board, validator);

			try {
				board.placeMark(position, currentPlayer.getMark());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}

			if (winChecker.hasWon(board, currentPlayer.getMark())) {
				board.displayBoard();
				System.out.println("Player " + currentPlayer.getMark() + " Wins!");
				return;
			}

			if (board.isFull()) {
				board.displayBoard();
				System.out.println("Match Draw!");
				return;
			}

			currentPlayer = switchPlayer(currentPlayer);
		}
	}

	private Player switchPlayer(Player current) {
		return current.getMark() == MarkType.X ? player2 : player1;
	}
}