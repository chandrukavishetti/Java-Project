package com.chandru.sudoku.model;

public class BoxValidator {

    public boolean validate(int[][] grid, int row, int col, int number) {

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {

            for (int j = startCol; j < startCol + 3; j++) {

                if (grid[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}