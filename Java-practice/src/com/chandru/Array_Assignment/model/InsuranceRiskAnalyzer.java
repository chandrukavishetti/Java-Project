package com.chandru.Array_Assignment.model;

import java.util.Scanner;

public class InsuranceRiskAnalyzer {
	private Scanner scanner;
	private int[] ages;
	private int[] riskScores;
	private int numOfCustomers;

	private int highRiskYouth = 0;
	private int seniorRisk = 0;
	private int veryHighRisk = 0;
	private int normalRisk = 0;
	private double totalRisk = 0;
	private int highestRisk = -1;
	private int highestIndex = 0;
	private String[] classifications;

	public InsuranceRiskAnalyzer() {
		this.scanner = new Scanner(System.in);
	}

	public void getCustomerCount() {
		while (true) {
			System.out.print("Enter the number of customers: ");
			if (scanner.hasNextInt()) {
				numOfCustomers = scanner.nextInt();
				if (numOfCustomers > 0) {
					initializeArrays();
					break;
				} else {
					System.out.println("Please enter a positive number!");
				}
			} else {
				System.out.println("Please enter a valid number!");
				scanner.next();
			}
		}
	}

	private void initializeArrays() {
		ages = new int[numOfCustomers];
		riskScores = new int[numOfCustomers];
		classifications = new String[numOfCustomers];
	}

	public void inputCustomerData() {
		for (int i = 0; i < numOfCustomers; i++) {
			System.out.println("\n--- Customer " + (i + 1) + " ---");
			ages[i] = getValidAge();
			riskScores[i] = getValidRiskScore();
		}
	}

	private int getValidAge() {
		while (true) {
			System.out.print("Enter age (1-120): ");
			if (scanner.hasNextInt()) {
				int age = scanner.nextInt();
				if (age > 0 && age < 120) {
					return age;
				} else {
					System.out.println("Please enter age between 1 and 120!");
				}
			} else {
				System.out.println("Please enter a valid number!");
				scanner.next();
			}
		}
	}

	private int getValidRiskScore() {
		while (true) {
			System.out.print("Enter risk score (0-100): ");
			if (scanner.hasNextInt()) {
				int score = scanner.nextInt();
				if (score >= 0 && score <= 100) {
					return score;
				} else {
					System.out.println("Please enter score between 0 and 100!");
				}
			} else {
				System.out.println("Please enter a valid number!");
				scanner.next();
			}
		}
	}

	public void processClassifications() {
		for (int i = 0; i < numOfCustomers; i++) {
			classifyCustomer(i);
			updateStatistics(i);
		}
	}

	private void classifyCustomer(int index) {
		if (ages[index] < 25 && riskScores[index] > 70) {
			classifications[index] = "High Risk Youth";
			highRiskYouth++;
		} else if (ages[index] >= 60) {
			classifications[index] = "Senior Risk";
			seniorRisk++;
		} else if (riskScores[index] >= 85) {
			classifications[index] = "Very High Risk";
			veryHighRisk++;
		} else {
			classifications[index] = "Normal Risk";
			normalRisk++;
		}
	}

	private void updateStatistics(int index) {
		totalRisk += riskScores[index];
		if (riskScores[index] > highestRisk) {
			highestRisk = riskScores[index];
			highestIndex = index;
		}
	}

	public int getNumOfCustomers() {
		return numOfCustomers;
	}

	public int[] getAges() {
		return ages;
	}

	public int[] getRiskScores() {
		return riskScores;
	}

	public String[] getClassifications() {
		return classifications;
	}

	public int getHighRiskYouth() {
		return highRiskYouth;
	}

	public int getSeniorRisk() {
		return seniorRisk;
	}

	public int getVeryHighRisk() {
		return veryHighRisk;
	}

	public int getNormalRisk() {
		return normalRisk;
	}

	public double getAverageRiskScore() {
		return totalRisk / numOfCustomers;
	}

	public int getHighestRisk() {
		return highestRisk;
	}

	public int getHighestIndex() {
		return highestIndex;
	}

	public void closeScanner() {
		if (scanner != null) {
			scanner.close();
		}
	}
}