package com.chandru.Assignment;

import java.util.Scanner;

public class Fraud_Transaction_detector {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number_of_transaction = 0;

		while (true) {
			System.out.print("Enter number of transactions: ");
			if (scanner.hasNextInt()) {
				number_of_transaction = scanner.nextInt();
				scanner.nextLine();
				if (number_of_transaction > 0) {
					break;
				} else {
					System.out.println("Error: Please enter a number greater than 0.");
				}
			} else {
				System.out.println("Invalid input! Please enter a valid whole number.");
				scanner.nextLine();
			}
		}

		double[] transactions = new double[number_of_transaction];

		System.out.println("\n--- Entering Transaction Amounts ---");
		for (int i = 0; i < number_of_transaction; i++) {
			while (true) {
				System.out.print("Transaction [" + i + "] Amount: ");
				if (scanner.hasNextDouble()) {
					double amount = scanner.nextDouble();
					scanner.nextLine();

					if (amount >= 0 && amount <= 1_000_000_000) {
						transactions[i] = amount;
						break;
					} else {
						System.out.println("Error: Amount must be between 0 and 1,000,000,000.");
					}
				} else {
					System.out.println("Invalid input! Enter numbers only.");
					scanner.nextLine();
				}
			}
		}

		double total = 0;
		boolean fraudDetected = false;
		final double THRESHOLD = 50000.0;

		System.out.println("\n--- Analysis Results ---");
		for (int i = 0; i < number_of_transaction; i++) {
			total += transactions[i];

			if (transactions[i] > THRESHOLD) {
				System.out.printf("Index %d: Suspicious (Amount: %.2f)%n", i, transactions[i]);
			}

			if (i >= 1) {
				if (transactions[i] > THRESHOLD && transactions[i - 1] > THRESHOLD) {
					fraudDetected = true;
				}
			}
		}

		double average = (number_of_transaction > 0) ? (total / number_of_transaction) : 0;

		System.out.println("\n----------------- SUMMARY -----------------");
		if (fraudDetected) {
			System.out.println("STATUS: [!] POTENTIAL FRAUD DETECTED [!]");
			System.out.println("PATTERN: Found 2+ consecutive transactions > " + THRESHOLD);
		} else {
			System.out.println("STATUS: No Fraudulent Pattern Detected.");
		}

		System.out.printf("Average Transaction Value: %.2f%n", average);

		if (average > 40000) {
			System.out.println("ACCOUNT TYPE: High Value Account");
		} else {
			System.out.println("ACCOUNT TYPE: Standard Account");
		}
		System.out.println("-------------------------------------------");

		scanner.close();
	}
}