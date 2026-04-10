package com.chandru.Array_Assignment.test;

import com.chandru.Array_Assignment.model.InsuranceRiskAnalyzer;

public class InsuranceRiskTest {
	public static void main(String[] args) {
		// Create analyzer object
		InsuranceRiskAnalyzer analyzer = new InsuranceRiskAnalyzer();

		// Get customer count
		analyzer.getCustomerCount();

		// Input customer data
		analyzer.inputCustomerData();

		// Process classifications
		analyzer.processClassifications();

		// Print results
		printResults(analyzer);

		// Close scanner
		analyzer.closeScanner();
	}

	// Helper method to print line separator
	private static void printLine(String character, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(character);
		}
		System.out.println();
	}

	// Method to print all results
	private static void printResults(InsuranceRiskAnalyzer analyzer) {
		// Print individual customer classifications
		System.out.println();
		printLine("=", 55);
		System.out.println("CUSTOMER CLASSIFICATION RESULTS");
		printLine("=", 55);

		for (int i = 0; i < analyzer.getNumOfCustomers(); i++) {
			String output = "Customer " + (i + 1) + " | Age: " + analyzer.getAges()[i] + " | Score: "
					+ analyzer.getRiskScores()[i] + " | " + analyzer.getClassifications()[i];
			System.out.println(output);
		}

		// Print summary report
		System.out.println();
		printLine("=", 55);
		System.out.println("SUMMARY REPORT");
		printLine("=", 55);
		System.out.println("High Risk Youth:    " + analyzer.getHighRiskYouth());
		System.out.println("Senior Risk:        " + analyzer.getSeniorRisk());
		System.out.println("Very High Risk:     " + analyzer.getVeryHighRisk());
		System.out.println("Normal Risk:        " + analyzer.getNormalRisk());
		printLine("-", 55);

		// Print average risk score
		String averageScore = String.format("%.2f", analyzer.getAverageRiskScore());
		System.out.println("Average Risk Score: " + averageScore);

		// Print highest risk customer
		System.out.println("Highest Risk Index: " + (analyzer.getHighestIndex() + 1) + " (Score: "
				+ analyzer.getHighestRisk() + ")");
		printLine("=", 55);
	}
}