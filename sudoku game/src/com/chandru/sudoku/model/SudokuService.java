package com.chandru.sudoku.model;

public class SudokuService {

	private RowValidator rowValidator;
	private ColumnValidator columnValidator;
	private BoxValidator boxValidator;

	public SudokuService() {

		rowValidator = new RowValidator();
		columnValidator = new ColumnValidator();
		boxValidator = new BoxValidator();
	}

	public boolean isValidMove(int[][] grid, int row, int col, int number) {
		return rowValidator.validate(grid, row, number) && columnValidator.validate(grid, col, number)
				&& boxValidator.validate(grid, row, col, number);
	}

	public void placeNumber(SudokuBoard board, int row, int col, int number) throws InvalidInputException {

		int[][] grid = board.getGrid();

		if (grid[row][col] != 0) {
			throw new InvalidInputException("Cell already filled");
		}

		boolean rowValid = rowValidator.validate(grid, row, number);
		boolean colValid = columnValidator.validate(grid, col, number);
		boolean boxValid = boxValidator.validate(grid, row, col, number);

		if (!rowValid) {
			throw new InvalidInputException("Number already exists in row");
		}

		if (!colValid) {
			throw new InvalidInputException("Number already exists in column");
		}

		if (!boxValid) {
			throw new InvalidInputException("Number already exists in 3x3 box");
		}

		board.setValue(row, col, number);
	}
}