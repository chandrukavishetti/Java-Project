package com.chandru.mini_project.model;

import java.util.Scanner;

public class Tic_Tac_Toe {
	public static void main(String[] args) {
		char[][] board = new char[3][3];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}

		char player = 'X';
		boolean gameOver = false;
		Scanner scanner = new Scanner(System.in);

		while (!gameOver) {
			printBoard(board);
			System.out.print("Player " + player + ", enter (row and col: 0, 1, or 2): ");

			if (scanner.hasNextInt()) {
				int row = scanner.nextInt();
				int col = scanner.nextInt();

				if (row >= 0 && row < 3 && col >= 0 && col < 3) {
					if (board[row][col] == ' ') {
						board[row][col] = player;
						gameOver = haveWon(board, player);

						if (gameOver) {
							printBoard(board);
							System.out.println("Congratulations! Player " + player + " has won!");
						} else if (isBoardFull(board)) {
							printBoard(board);
							System.out.println("It's a draw!");
							gameOver = true;
						} else {
							player = (player == 'X') ? 'O' : 'X';
						}
					} else {
						System.out.println("That spot is already taken");
					}
				} else {
					System.out.println(" Please enter numbers between 0 and 2.");
				}
			} else {
				System.out.println(" Please enter numbers only.");
				scanner.next();
			}
		}
		scanner.close();
	}

	public static boolean haveWon(char[][] board, char player) {
		for (int i = 0; i < 3; i++) {
			if ((board[i][0] == player && board[i][1] == player && board[i][2] == player)
					|| (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
				return true;
			}
		}

		return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
				|| (board[0][2] == player && board[1][1] == player && board[2][0] == player);
	}

	public static boolean isBoardFull(char[][] board) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == ' ')
					return false;
			}
		}
		return true;
	}

	public static void printBoard(char[][] board) {
		System.out.println("-------------");
		for (int row = 0; row < board.length; row++) {
			System.out.print("| ");
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " | ");
			}
			System.out.println("\n-------------");
		}
	}
}