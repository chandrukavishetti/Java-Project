package com.chandru.string_assignment.test;

import java.util.Scanner;
import com.chandru.string_assignment.model.FirstNonRepeatingCharModel;

public class FirstNonRepeatingCharTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter a string to find the first non-repeating character:");
			String userInput = scanner.nextLine();

			if (userInput == null || userInput.trim().isEmpty()) {
				throw new Exception("You must enter a valid string.");
			}

			FirstNonRepeatingCharModel model = new FirstNonRepeatingCharModel(userInput);
			model.findFirstChar();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}