package com.chandru.sudoku.model;

public class SudokuBoard {

    private int[][] grid;

    public SudokuBoard() {
        grid = new int[9][9];
    }

    public SudokuBoard(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getValue(int row, int col) {
        return grid[row][col];
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }
}