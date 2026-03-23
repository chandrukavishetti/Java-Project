package com.chandru.sudoku.model;

import java.util.Random;

public class BoardFactory {
	private SudokuService service = new SudokuService();
	private Random random = new Random();

	public SudokuBoard createBoard(int fillCount) {
		int[][] grid = new int[9][9];

		// Fill the board completely with a valid solution
		fillBoard(grid);

		// Remove digits until we hit the target count
		removeDigits(grid, 81 - fillCount);

		return new SudokuBoard(grid);
	}

	private boolean fillBoard(int[][] grid) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (grid[row][col] == 0) {

					int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
					shuffleArray(numbers);

					for (int num : numbers) {
						if (service.isValidMove(grid, row, col, num)) {
							grid[row][col] = num;
							if (fillBoard(grid))
								return true;
							grid[row][col] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private void removeDigits(int[][] grid, int countToRemove) {
		int removed = 0;
		while (removed < countToRemove) {
			int r = random.nextInt(9);
			int c = random.nextInt(9);
			if (grid[r][c] != 0) {
				grid[r][c] = 0;
				removed++;
			}
		}
	}

	private void shuffleArray(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			int a = array[index];
			array[index] = array[i];
			array[i] = a;
		}
	}
}