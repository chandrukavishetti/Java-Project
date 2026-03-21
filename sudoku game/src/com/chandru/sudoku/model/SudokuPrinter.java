package com.chandru.sudoku.model;

public class SudokuPrinter {

    public void printBoard(int[][] grid) {

        System.out.println("\nCurrent Sudoku Board\n");

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                System.out.print(grid[i][j] + " ");

                if ((j + 1) % 3 == 0 && j < 8) {
                    System.out.print("| ");
                }
            }

            System.out.println();

            if ((i + 1) % 3 == 0 && i < 8) {
                System.out.println("---------------------");
            }
        }
    }
}