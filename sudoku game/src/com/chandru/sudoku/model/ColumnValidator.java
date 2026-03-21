package com.chandru.sudoku.model;

public class ColumnValidator {

    public boolean validate(int[][] grid, int col, int number) {

        for (int i = 0; i < 9; i++) {

            if (grid[i][col] == number) {
                return false;
            }
        }

        return true;
    }
}