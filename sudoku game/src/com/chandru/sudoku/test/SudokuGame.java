package com.chandru.sudoku.test;

import com.chandru.sudoku.model.*;

public class SudokuGame {

	public static void main(String[] args) {


		Menu menu = new Menu();
		BoardFactory factory = new BoardFactory();

		int choice = menu.chooseDifficulty();

		SudokuBoard board = selectBoard(choice, factory);

		InputHandler input = new InputHandler();
		SudokuPrinter printer = new SudokuPrinter();
		SudokuService service = new SudokuService();

		startGame(board, input, printer, service);
		
	}

	private static SudokuBoard selectBoard(int choice, BoardFactory factory) {

		if (choice == 1) {
			return factory.createEasyBoard();
		}

		return factory.createDifficultBoard();
	}

	private static void startGame(SudokuBoard board, InputHandler input, SudokuPrinter printer, SudokuService service) {

		while (true) {

			try {

				printer.printBoard(board.getGrid());

				int row = input.readRow();
				int col = input.readColumn();
				int num = input.readNumber();

				service.placeNumber(board, row, col, num);

			}

			catch (InvalidInputException e) {

				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}