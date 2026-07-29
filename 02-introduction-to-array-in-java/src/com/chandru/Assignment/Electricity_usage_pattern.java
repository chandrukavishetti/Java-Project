package com.chandru.Assignment;

import java.util.Scanner;

public class Electricity_usage_pattern {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number_of_days = 0;

		while (true) {
			System.out.print("Enter number of days (1-31): ");
			if (scanner.hasNextInt()) {
				number_of_days = scanner.nextInt();
				scanner.nextLine();
				if (number_of_days > 0 && number_of_days <= 31) {
					break;
				} else {
					System.out.println("Error: Please enter a logical number of days (1-31).");
				}
			} else {
				System.out.println("Invalid input! Please enter a whole number.");
				scanner.nextLine();
			}
		}

		int[] usage = new int[number_of_days];

		System.out.println("\n--- Enter Daily Usage (kWh) ---");
		for (int i = 0; i < number_of_days; i++) {
			while (true) {
				System.out.print("Day " + i + ": ");
				if (scanner.hasNextInt()) {
					int daily_usage = scanner.nextInt();
					scanner.nextLine();
					if (daily_usage >= 0 && daily_usage <= 5000) {
						usage[i] = daily_usage;
						break;
					} else {
						System.out.println("Error: Usage must be between 0 and 5000.");
					}
				} else {
					System.out.println("Invalid input! Enter numbers only.");
					scanner.nextLine();
				}
			}
		}

		int highConsumptionCount = 0;
		long totalUsage = 0;
		boolean overloadWarning = false;

		System.out.println("\nDaily Classification:");
		for (int i = 0; i < number_of_days; i++) {
			totalUsage += usage[i];

			if (usage[i] > 500) {
				System.out.printf("Day %d: [%d kWh] -> High Consumption%n", i, usage[i]);
				highConsumptionCount++;
			} else if (usage[i] < 100) {
				System.out.printf("Day %d: [%d kWh] -> Low Usage Alert%n", i, usage[i]);
			} else {
				System.out.printf("Day %d: [%d kWh] -> Normal Usage%n", i, usage[i]);
			}

			if (i >= 2) {
				if (usage[i] > 500 && usage[i - 1] > 500 && usage[i - 2] > 500) {
					overloadWarning = true;
				}
			}
		}

		double average = (number_of_days > 0) ? (double) totalUsage / number_of_days : 0;

		String separator = "==============================";
		System.out.println("\n" + separator);
		System.out.println("        SUMMARY REPORT");
		System.out.println(separator);

		System.out.println("High Consumption Days: " + highConsumptionCount);
		System.out.printf("Average Daily Usage:   %.2f kWh%n", average);

		if (overloadWarning) {
			System.out.println("ALERT: Overload Warning! (3+ consecutive high days)");
		} else {
			System.out.println("Status: No Overload Pattern Detected.");
		}

		if (average > 400) {
			System.out.println("NOTICE: Heavy Usage Month Detected!");
		}

		scanner.close();
	}
}