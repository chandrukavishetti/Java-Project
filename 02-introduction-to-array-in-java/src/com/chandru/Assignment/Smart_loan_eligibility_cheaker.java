package com.chandru.Assignment;

import java.util.Scanner;

public class Smart_loan_eligibility_cheaker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number_of_applicant = 0;

		while (true) {
			System.out.print("Enter number of applicants: ");
			if (scanner.hasNextInt()) {
				number_of_applicant = scanner.nextInt();
				scanner.nextLine();
				if (number_of_applicant > 0)
					break;
				else
					System.out.println("Error: Number of applicants must be at least 1.");
			} else {
				System.out.println("Invalid input! Please enter a whole number.");
				scanner.nextLine();
			}
		}

		int[] creditScores = new int[number_of_applicant];
		double[] monthlyIncomes = new double[number_of_applicant];
		int[] existingLoans = new int[number_of_applicant];

		for (int i = 0; i < number_of_applicant; i++) {
			System.out.println("\n--- Processing Data for Applicant " + i + " ---");

			while (true) {
				System.out.print("  Credit Score (1-900): ");
				if (scanner.hasNextInt()) {
					int score = scanner.nextInt();
					scanner.nextLine();
					if (score >= 1 && score <= 900) {
						creditScores[i] = score;
						break;
					}
					System.out.println("  Error: Score must be between 1 and 900.");
				} else {
					System.out.println("  Error: Please enter a numeric value.");
					scanner.nextLine();
				}
			}

			while (true) {
				System.out.print("  Monthly Income: ");
				if (scanner.hasNextDouble()) {
					double income = scanner.nextDouble();
					scanner.nextLine();
					if (income >= 0) {
						monthlyIncomes[i] = income;
						break;
					}
					System.out.println("  Error: Income cannot be negative.");
				} else {
					System.out.println("  Error: Please enter a valid decimal or number.");
					scanner.nextLine();
				}
			}

			while (true) {
				System.out.print("  Number of existing loans: ");
				if (scanner.hasNextInt()) {
					int loans = scanner.nextInt();
					scanner.nextLine();
					if (loans >= 0) {
						existingLoans[i] = loans;
						break;
					}
					System.out.println("  Error: Loan count cannot be negative.");
				} else {
					System.out.println("  Error: Please enter a whole number.");
					scanner.nextLine();
				}
			}
		}

		int approvals = 0;
		int rejections = 0;
		int bestApplicantIndex = -1;
		int bestCreditScore = -1;

		System.out.println("\n================ ELIGIBILITY RESULTS ================");

		for (int i = 0; i < number_of_applicant; i++) {
			String status;
			String reason = "Criteria Met";

			boolean lowCredit = creditScores[i] < 600;
			boolean lowIncome = monthlyIncomes[i] < 25000;
			boolean tooManyLoans = existingLoans[i] >= 3;

			if (lowCredit || lowIncome || tooManyLoans) {
				status = "REJECTED";
				rejections++;

				reason = lowCredit ? "Low Credit Score" : (lowIncome ? "Low Income" : "Too many existing loans");
			} else {
				approvals++;
				if (creditScores[i] >= 800 && monthlyIncomes[i] > 100000) {
					status = "INSTANT APPROVAL";
				} else {
					status = "STANDARD REVIEW";
				}

				if (creditScores[i] > bestCreditScore) {
					bestCreditScore = creditScores[i];
					bestApplicantIndex = i;
				}
			}

			System.out.printf("Applicant %d: %-18s | Reason/Note: %s%n", i, status, reason);
		}

		System.out.println("\n----------------- FINAL SUMMARY -----------------");
		System.out.println("Total Approvals:   " + approvals);
		System.out.println("Total Rejections:  " + rejections);

		if (bestApplicantIndex != -1) {
			System.out.println("Top Candidate:     Index " + bestApplicantIndex + " (Score: " + bestCreditScore + ")");
		} else {
			System.out.println("Top Candidate:     None (No approvals)");
		}

		scanner.close();
	}
}
