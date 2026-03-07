package com.chandru.array;

import java.util.Scanner;

public class Shifting_char_in_string {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int shiftPosition = 0;
		String userInput = "";

		while (true) {

			System.out.print("Enter the String: ");
			userInput = scanner.nextLine();

			if (userInput.trim().isEmpty()) {
				System.out.println("String cannot be empty!");
				continue;
			}

			System.out.print("Enter the Shift position: ");

			if (!scanner.hasNextInt()) {
				System.out.println("Please enter a valid integer!");
				scanner.nextLine(); // clear wrong input
				continue;
			}

			shiftPosition = scanner.nextInt();
			scanner.nextLine(); // clear buffer

			// Accept both positive and negative shift
			break;
		}

		// Normalize shift value (handles large numbers)
		shiftPosition = shiftPosition % 26;

		char[] array = userInput.toCharArray();

		for (int i = 0; i < array.length; i++) {

			char each_charecter = array[i];

			// For lowercase letters
			if (each_charecter >= 'a' && each_charecter <= 'z') {
				array[i] = (char) ((each_charecter - 'a' + shiftPosition + 26) % 26 + 'a');
			}
			// For uppercase letters
			else if (each_charecter >= 'A' && each_charecter <= 'Z') {
				array[i] = (char) ((each_charecter - 'A' + shiftPosition + 26) % 26 + 'A');
			}
			// Special characters remain same
			else {
				array[i] = each_charecter;
			}
		}

		String result = new String(array);

		System.out.println("Shifted String: " + result);

		scanner.close();
	}
}
