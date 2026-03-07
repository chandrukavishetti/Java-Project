package com.chandru.constructor.test;

import com.chandru.constructor.model.InsuranceClaim;
import com.chandru.constructor.model.CorporateClaim;
import java.util.Scanner;

public class InsuranceTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String policyNumber;
		double claimAmount;

		while (true) {
			System.out.print("Enter Policy Number: ");
			policyNumber = scanner.nextLine().trim();

			if (policyNumber.isEmpty()) {
				System.out.println("Policy number cannot be empty.");
				continue;
			}

			boolean onlyDigits = true;
			for (int i = 0; i < policyNumber.length(); i++) {
				if (!Character.isDigit(policyNumber.charAt(i))) {
					onlyDigits = false;
					break;
				}
			}

			if (!onlyDigits) {
				System.out.println("Policy number must contain only numbers (no alphabets or symbols).");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("Enter Claim Amount: ");
			String input = scanner.nextLine().trim();

			// Detect leading zeros (e.g., 095) unless it's a decimal like 0.5
			if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
				System.out.println("Invalid format. Amount should not start with leading zeros.");
				continue;
			}

			try {
				claimAmount = Double.parseDouble(input);
				if (claimAmount < 0) {
					System.out.println("Claim amount cannot be negative.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Enter valid numeric amount without alphabets.");
			}
		}

		System.out.println("Select Claim Type:\n1. Normal Claim\n2. Corporate Claim");

		int choice;
		while (true) {
			System.out.print("Enter choice: ");
			if (!scanner.hasNextInt()) {
				System.out.println("Enter valid choice (1 or 2)");
				scanner.next();
				continue;
			}

			choice = scanner.nextInt();
			scanner.nextLine();

			if (choice != 1 && choice != 2) {
				System.out.println("Invalid choice. Select 1 or 2.");
				continue;
			}
			break;
		}

		if (choice == 1) {
			InsuranceClaim claim = new InsuranceClaim(policyNumber, claimAmount);
			System.out.println("Claim Created Successfully!");
			System.out.println("Claim ID: " + claim.getClaimId());
			System.out.println("Status: " + claim.getStatus());
			scanner.close();
			return;
		}

		CorporateClaim corpClaim = new CorporateClaim(policyNumber, claimAmount);
		System.out.println("Corporate Claim Created Successfully!");
		System.out.println("Claim ID: " + corpClaim.getClaimId());
		System.out.println("Status: " + corpClaim.getStatus());
		System.out.println("Processing Fee Applied.");

		scanner.close();
	}
}