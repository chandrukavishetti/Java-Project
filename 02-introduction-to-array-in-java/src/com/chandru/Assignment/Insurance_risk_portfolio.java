package com.chandru.Assignment;

import java.util.Scanner;

public class Insurance_risk_portfolio {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number_of_customer = 0;

		while (true) {
			System.out.print("Enter number of customers: ");
			if (scanner.hasNextInt()) {
				number_of_customer = scanner.nextInt();
				if (number_of_customer > 0) {
					break;
				} else {
					System.out.println("Error: Number must be greater than 0.");
				}
			} else {
				System.out.println("Error: Please enter a valid whole number.");
			}
			scanner.nextLine(); 
		}

		int[] ages = new int[number_of_customer];
		int[] riskScores = new int[number_of_customer];

		System.out.println("\n--- Entering Ages ---");
		for (int i = 0; i < number_of_customer; i++) {
			while (true) {
				System.out.print("Age of customer " + i + ": ");
				if (scanner.hasNextInt()) {
					int age = scanner.nextInt();
					if (age > 0 && age < 120) { // Added a logical upper bound for age
						ages[i] = age;
						break;
					} else {
						System.out.println("Error: Please enter a realistic age (1-120).");
					}
				} else {
					System.out.println("Error: Invalid input. Enter a number.");
				}
				scanner.nextLine();
			}
		}

		System.out.println("\n--- Entering Risk Scores (0-100) ---");
		for (int i = 0; i < number_of_customer; i++) {
			while (true) {
				System.out.print("Risk score for customer " + i + ": ");
				if (scanner.hasNextInt()) {
					int score = scanner.nextInt();
					if (score >= 0 && score <= 100) {
						riskScores[i] = score;
						break;
					} else {
						System.out.println("Error: Score must be between 0 and 100.");
					}
				} else {
					System.out.println("Error: Invalid input. Enter a number.");
				}
				scanner.nextLine();
			}
		}

		int highRiskYouth = 0, seniorRisk = 0, veryHighRisk = 0, normalRisk = 0;
		double totalRisk = 0;
		int highestRisk = -1;
		int highestIndex = 0;

		System.out.println("\n--- Customer Classification ---");
		for (int i = 0; i < number_of_customer; i++) {
			String category;

			if (ages[i] < 25 && riskScores[i] > 70) {
				category = "High Risk Youth";
				highRiskYouth++;
			} else if (ages[i] >= 60) {
				category = "Senior Risk";
				seniorRisk++;
			} else if (riskScores[i] >= 85) {
				category = "Very High Risk";
				veryHighRisk++;
			} else {
				category = "Normal Risk";
				normalRisk++;
			}

			System.out.printf("Customer %d (Age: %d, Score: %d): %s%n", i, ages[i], riskScores[i], category);

			totalRisk += riskScores[i];
			if (riskScores[i] > highestRisk) {
				highestRisk = riskScores[i];
				highestIndex = i;
			}
		}

		System.out.println("\n----- Summary Report -----");
		System.out.println("High Risk Youth:    " + highRiskYouth);
		System.out.println("Senior Risk:        " + seniorRisk);
		System.out.println("Very High Risk:     " + veryHighRisk);
		System.out.println("Normal Risk:        " + normalRisk);
		System.out.printf("Average Risk Score: %.2f%n", (totalRisk / number_of_customer));
		System.out.println("Highest Risk Index: " + highestIndex + " (Score: " + highestRisk + ")");

		scanner.close();
	}
}