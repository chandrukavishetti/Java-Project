package com.chandru.sudoku.model;

public class RowValidator {

    public boolean validate(int[][] grid, int row, int number) {

        for (int i = 0; i < 9; i++) {

            if (grid[row][i] == number) {
                return false;
            }
        }

        return true;
    }
}