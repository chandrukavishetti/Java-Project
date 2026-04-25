package com.chandru.stud_app.util;

import java.util.Scanner;

import com.chandru.stud_app.dao.StudentDAO;

public class InputValidator {
	private static Scanner scanner = new Scanner(System.in);
	private static StudentDAO sdao = new StudentDAO();

	public static int readInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input please enter the valid input");
			}
		}
	}

	public static String readName(String prompt) {
		while (true) {
			System.out.println(prompt);
			String input = scanner.nextLine().trim();
			if (input.matches("[a-zA-Z\\s]+")) {
				return input;
			}
			System.out.println("invalid input enter only alphbets");
		}
	}

	public static double readMarks(String prompt) {
		while (true) {
			System.out.println(prompt);
			try {
				return Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("invalid input please enter the valid input");
			}
		}
	}

	public static int readFromMenu(int min, int max) {
		while (true) {
			int val = readInt();
			if (val >= min && val <= max)
				return val;
			System.out.println("enter the number between " + max + " - " + min);
		}
	}

}
