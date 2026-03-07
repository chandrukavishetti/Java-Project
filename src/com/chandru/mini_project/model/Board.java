package com.chandru.mini_project.model;

public class Board {

	private final MarkType[][] board;
	private final int size;

	public Board(int size) {
		this.size = size;
		board = new MarkType[size][size];
	}

	public int getSize() {
		return size;
	}

	public void displayBoard() {
		int cellNumber = 1;

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {

				if (board[row][col] == null) {
					System.out.printf("%-4d", cellNumber);
				} else {
					System.out.printf("%-4s", board[row][col]);
				}
				cellNumber++;
			}
			System.out.println();
		}
	}

	public void placeMark(int position, MarkType mark) {
		int row = (position - 1) / size;
		int col = (position - 1) % size;

		if (board[row][col] != null) {
			throw new IllegalArgumentException("Cell already occupied!");
		}

		board[row][col] = mark;
	}

	public boolean isFull() {
		for (MarkType[] rows : board) {
			for (MarkType cell : rows) {
				if (cell == null)
					return false;
			}
		}
		return true;
	}

	public MarkType[][] getBoard() {
		return board;
	}
}