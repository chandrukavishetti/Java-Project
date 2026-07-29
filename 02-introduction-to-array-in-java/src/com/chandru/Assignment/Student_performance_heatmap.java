package com.chandru.Assignment;

import java.util.Scanner;

public class Student_performance_heatmap {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number_of_students = 0;
		final int SUBJECTS_COUNT = 5;

		while (true) {
			System.out.print("Enter number of students: ");
			if (scanner.hasNextInt()) {
				number_of_students = scanner.nextInt();
				scanner.nextLine(); // Clear buffer
				if (number_of_students > 0)
					break;
				else
					System.out.println("Error: Must have at least 1 student.");
			} else {
				System.out.println("Invalid input! Please enter a valid integer.");
				scanner.nextLine();
			}
		}

		int[][] marks = new int[number_of_students][SUBJECTS_COUNT];

		for (int i = 0; i < number_of_students; i++) {
			System.out.println("\n--- Marks for Student " + i + " ---");
			for (int j = 0; j < SUBJECTS_COUNT; j++) {
				while (true) {
					System.out.print("  Subject " + j + " (0-100): ");
					if (scanner.hasNextInt()) {
						int value = scanner.nextInt();
						scanner.nextLine();
						if (value >= 0 && value <= 100) {
							marks[i][j] = value;
							break;
						} else {
							System.out.println("  Error: Marks must be between 0 and 100.");
						}
					} else {
						System.out.println("  Error: Enter numeric values only.");
						scanner.nextLine();
					}
				}
			}
		}

		int distinctionCount = 0;
		double[] subjectTotals = new double[SUBJECTS_COUNT];

		System.out.println("\n================ STUDENT RESULTS ================");
		for (int i = 0; i < number_of_students; i++) {
			int total = 0;
			boolean hasFailedAny = false;

			for (int j = 0; j < SUBJECTS_COUNT; j++) {
				total += marks[i][j];
				subjectTotals[j] += marks[i][j];

				if (marks[i][j] < 35) {
					hasFailedAny = true;
				}
			}

			double average = total / (double) SUBJECTS_COUNT;
			String result;

			if (hasFailedAny) {
				result = "FAIL (Sub-35 marks found)";
			} else if (average >= 85) {
				result = "DISTINCTION";
				distinctionCount++;
			} else if (average >= 60) {
				result = "FIRST CLASS";
			} else if (average >= 50) {
				result = "SECOND CLASS";
			} else {
				result = "PASS";
			}

			System.out.printf("Student %d | Avg: %6.2f | Result: %s%n", i, average, result);
		}

		int bestSubjectIndex = 0;
		double highestAverage = -1;

		System.out.println("\n--- Subject Analysis ---");
		for (int j = 0; j < SUBJECTS_COUNT; j++) {
			double currentSubAvg = subjectTotals[j] / number_of_students;
			System.out.printf("Subject %d Average: %.2f%n", j, currentSubAvg);

			if (currentSubAvg > highestAverage) {
				highestAverage = currentSubAvg;
				bestSubjectIndex = j;
			}
		}

		System.out.println("\n---------------- SUMMARY ----------------");
		System.out.println("Total Distinctions: " + distinctionCount);
		System.out.printf("Best Performing Subject: Subject %d (Avg: %.2f)%n", bestSubjectIndex, highestAverage);
		System.out.println("-----------------------------------------");

		scanner.close();
	}
}