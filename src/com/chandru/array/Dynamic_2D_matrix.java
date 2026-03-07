package com.chandru.array;

import java.util.Scanner;

public class Dynamic_2D_matrix {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int row = 0;
		int column = 0;

		while (true) {
			System.out.print("Enter number of rows (M): ");

			if (scanner.hasNextInt()) {
				row = scanner.nextInt();
			} else {
				System.out.println("Invalid input! Please enter an integer.");
				scanner.next(); // clear invalid input
				continue;
			}

			System.out.print("Enter number of columns (N): ");

			if (scanner.hasNextInt()) {
				column = scanner.nextInt();
			} else {
				System.out.println("Invalid input! Please enter an integer.");
				scanner.next();
				continue;
			}

			if (row > 0 && column > 0) {
				break;
			} else {
				System.out.println("Rows and Columns must be positive numbers.");
			}
		}

		// Create matrix
		int[][] matrix = new int[row][column];

		// Taking elements from user
		System.out.println("Enter the elements of the matrix:");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {

				while (!scanner.hasNextInt()) {
					System.out.println("Invalid input! Please enter an integer.");
					scanner.next();
				}

				matrix[i][j] = scanner.nextInt();
			}
		}

		// Display matrix
		System.out.println("Matrix you entered:");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		scanner.close();
	}
}