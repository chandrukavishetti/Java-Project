package com.chandru.string_assignment.model;

public class FirstNonRepeatingCharModel {
	private String input;

	public FirstNonRepeatingCharModel(String input) {
		this.input = input;
	}

	public void findFirstChar() {
		try {
			if (input == null || input.isEmpty()) {
				throw new Exception("Input string cannot be empty.");
			}

			// We use an array of 256 to cover all standard ASCII characters
			int[] charCounts = new int[256];

			for (int i = 0; i < input.length(); i++) {
				charCounts[input.charAt(i)]++;
			}

			char result = '\0'; // Null character as placeholder
			boolean found = false;

			for (int i = 0; i < input.length(); i++) {
				if (charCounts[input.charAt(i)] == 1) {
					result = input.charAt(i);
					found = true;
					break;
				}
			}

			if (found) {
				System.out.println("The first non-repeating character is: " + result);
			} else {
				System.out.println("No non-repeating characters found.");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}