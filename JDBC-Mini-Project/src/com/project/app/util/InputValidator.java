package com.project.app.util;

import java.util.Scanner;
import com.project.app.dao.StudentDAO;

public class InputValidator {
	private static Scanner sc = new Scanner(System.in);
	private static StudentDAO sdao = new StudentDAO();

	public static int readInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Invalid input! Please enter a valid number: ");
			}
		}
	}

	public static int readMenuChoice(int min, int max) {
		while (true) {
			int val = readInt();
			if (val >= min && val <= max)
				return val;
			System.out.print("Error: Please select a valid option (" + min + "-" + max + "): ");
		}
	}

	public static int readExistingId(String prompt) {
		while (true) {
			System.out.print(prompt);
			int id = readInt();
			try {
				if (sdao.studentExists(id)) {
					return id;
				} else {
					System.out.println("Error: Student ID " + id + " does not exist in our records.");
				}
			} catch (Exception e) {
				System.out.println("Database error occurred.");
			}
		}
	}

	public static int readUniqueId(String prompt) {
		while (true) {
			System.out.print(prompt);
			int id = readInt();
			try {
				if (id <= 0) {
					System.out.println("ID must be a positive number.");
				} else if (sdao.studentExists(id)) {
					System.out.println("Error: Student ID already exists! Enter a unique ID.");
				} else {
					return id;
				}
			} catch (Exception e) {
				System.out.println("Database error occurred.");
			}
		}
	}

	public static String readValidName(String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();
			if (input.matches("^[a-zA-Z\\s]+$") && !input.isEmpty())
				return input;
			System.out.println("Invalid Name! Use alphabets only.");
		}
	}

	public static double readValidDouble(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				double val = Double.parseDouble(sc.nextLine());
				if (val > 0)
					return val;
				System.out.println("Amount must be positive.");
			} catch (NumberFormatException e) {
				System.out.println("Invalid format! Enter a decimal number.");
			}
		}
	}
}