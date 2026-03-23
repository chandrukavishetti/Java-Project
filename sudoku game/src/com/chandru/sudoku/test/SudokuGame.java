package com.chandru.sudoku.test;

import com.chandru.sudoku.model.*;

public class SudokuGame {
	public static void main(String[] args) {
		Menu menu = new Menu();
		BoardFactory factory = new BoardFactory();

		int choice = menu.chooseDifficulty();

		int fillCount = (choice == 1) ? 60 : (choice == 2) ? 40 : 20;

		SudokuBoard board = factory.createBoard(fillCount);
		InputHandler input = new InputHandler();
		SudokuPrinter printer = new SudokuPrinter();
		SudokuService service = new SudokuService();

		while (true) {
			try {
				printer.printBoard(board.getGrid());
				service.placeNumber(board, input.readRow(), input.readColumn(), input.readNumber());
			} catch (InvalidInputException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}