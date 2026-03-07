package com.chandru.array;

import java.util.Scanner;

public class Peak_Element_in_array {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int arraySize = 0;

		// Validate array size
		while (true) {
			System.out.print("Enter the size of the array: ");

			if (!scanner.hasNextInt()) {
				System.out.println("Please enter a valid integer!");
				scanner.nextLine();
				continue;
			}

			arraySize = scanner.nextInt();

			if (arraySize <= 0) {
				System.out.println("Size must be positive!");
				continue;
			}

			break;
		}

		int[] array = new int[arraySize];

		// Take array elements safely
		System.out.println("Enter the array elements one by one:");

		for (int i = 0; i < arraySize; i++) {

			while (!scanner.hasNextInt()) {
				System.out.println("Please enter integers only!");
				scanner.nextLine();
			}

			array[i] = scanner.nextInt();
		}

		// Print entered array
		System.out.print("You entered array: [ ");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");

		// Find Peak Elements
		System.out.println("Peak Elements are:");

		if (arraySize == 1) {
			System.out.println(array[0]);
		} else {

			// Check first element
			if (array[0] >= array[1]) {
				System.out.println(array[0]);
			}

			// Check middle elements
			for (int i = 1; i < arraySize - 1; i++) {
				if (array[i] >= array[i - 1] && array[i] >= array[i + 1]) {
					System.out.println(array[i]);
				}
			}

			// Check last element
			if (array[arraySize - 1] >= array[arraySize - 2]) {
				System.out.println(array[arraySize - 1]);
			}
		}

		scanner.close();
	}
}
