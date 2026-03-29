package com.chandru.sudoku.model;

public class SudokuController {
	private InputHandler input = new InputHandler();
	private SudokuPrinter printer = new SudokuPrinter();
	private SudokuService service = new SudokuService();
	private BoardFactory factory = new BoardFactory();
	private Menu menu = new Menu();

	public void start() {
		boolean keepPlaying = true;
		while (keepPlaying) {
			int choice = menu.chooseDifficulty();
			runMatch(choice);
			keepPlaying = askToContinue();
		}
		System.out.println("Game Terminated. Goodbye!");
	}

	private void runMatch(int choice) {
		int fillCount = (choice == 1) ? 60 : (choice == 2) ? 40 : 20;
		int maxMistakes = (choice == 1) ? 10 : (choice == 2) ? 7 : 4;
		int mistakes = 0;

		SudokuBoard board = factory.createBoard(fillCount);

		while (mistakes < maxMistakes) {
			printer.printBoard(board.getGrid());
			System.out.println("Mistakes: " + mistakes + " / " + maxMistakes);

			try {
				int r = input.readRow();
				int c = input.readColumn();
				int n = input.readNumber();
				service.placeNumber(board, r, c, n);

				if (isWon(board.getGrid())) {
					System.out.println("Congratulations! You won!");
					return;
				}
			} catch (InvalidInputException e) {
				if (e.getMessage().contains("exists") || e.getMessage().contains("filled")) {
					mistakes++;
				}
				System.out.println("Error: " + e.getMessage());
			}
		}
		System.out.println("\nGAME OVER! Too many mistakes.");
	}

	private boolean isWon(int[][] grid) {
		for (int[] row : grid) {
			for (int val : row)
				if (val == 0)
					return false;
		}
		return true;
	}

	private boolean askToContinue() {
		System.out.println("\n1. Play Again\n2. Exit");
		try {
			return input.readMenuChoice(1, 2) == 1;
		} catch (Exception e) {
			return false;
		}
	}
}