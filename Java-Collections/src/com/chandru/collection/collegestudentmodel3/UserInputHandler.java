package com.chandru.collection.collegestudentmodel3;

import java.util.Scanner;

public class UserInputHandler {

	private Scanner sc = new Scanner(System.in);

	public int readInt(String msg) {

		while (true) {

			System.out.print(msg);

			try {

				int value = Integer.parseInt(sc.nextLine());

				if (value <= 0) {
					System.out.println("Enter positive number");
					continue;
				}

				return value;

			} catch (Exception e) {
				System.out.println("Invalid number");
			}
		}
	}

	public String readString(String msg) {

		while (true) {

			System.out.print(msg);

			String value = sc.nextLine();

			if (value.trim().isEmpty()) {

				System.out.println("Cannot be empty");
				continue;
			}

			return value;
		}
	}

	public int readMarks(String msg) {

		while (true) {

			System.out.print(msg);

			try {

				int marks = Integer.parseInt(sc.nextLine());

				if (marks < 0 || marks > 100) {

					System.out.println("Marks should be between 0 and 100");
					continue;
				}

				return marks;

			} catch (Exception e) {

				System.out.println("Invalid marks");
			}
		}
	}

	public int readStudentType() {

		while (true) {

			System.out.println("\n1. Undergraduate Student");
			System.out.println("2. Postgraduate Student");

			try {

				int choice = Integer.parseInt(sc.nextLine());

				if (choice == 1 || choice == 2)
					return choice;

				System.out.println("Choose 1 or 2");

			} catch (Exception e) {

				System.out.println("Invalid choice");
			}
		}
	}
}