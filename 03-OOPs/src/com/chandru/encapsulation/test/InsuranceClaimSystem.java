package com.chandru.encapsulation.test;

import java.util.Scanner;
import com.chandru.encapsulation.model.InsuranceClaim;

public class InsuranceClaimSystem {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String policyNumber;
		double claimAmount;

		while (true) {
			System.out.print("Enter Policy Number: ");
			policyNumber = scanner.nextLine().trim();

			if (policyNumber.isEmpty()) {
				System.out.println("Invalid policy number. Cannot be blank.");
				continue;
			}

			// Strict Digit-Only Validation
			boolean onlyDigits = true;
			for (int i = 0; i < policyNumber.length(); i++) {
				char ch = policyNumber.charAt(i);
				if (!Character.isDigit(ch)) {
					onlyDigits = false;
					break;
				}
			}

			if (!onlyDigits) {
				System.out.println("Invalid policy number. Only numbers are allowed (no alphabets or symbols).");
				continue;
			}

			// Strict leading zero check for policy number
			if (policyNumber.length() > 1 && policyNumber.startsWith("0")) {
				System.out.println("Invalid policy number. Cannot start with a leading zero.");
				continue;
			}

			break;
		}

		while (true) {
			System.out.print("Enter Claim Amount: ");
			String input = scanner.next().trim();

			if (input.length() > 1 && input.startsWith("0") && !input.startsWith("0.")) {
				System.out.println("Invalid format. Numbers should not start with leading zeros.");
				continue;
			}

			boolean isNumeric = true;
			int dotCount = 0;
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '.') {
					dotCount++;
					continue;
				}
				if (!Character.isDigit(ch)) {
					isNumeric = false;
					break;
				}
			}

			if (!isNumeric || dotCount > 1) {
				System.out.println("Invalid input. Enter numeric value only.");
				continue;
			}

			claimAmount = Double.parseDouble(input);
			if (claimAmount < 0) {
				System.out.println("Claim amount cannot be negative.");
				continue;
			}
			break;
		}

		InsuranceClaim claim = new InsuranceClaim(policyNumber, claimAmount);

		int choice;

		do {
			System.out.println("\n1. Approve Claim");
			System.out.println("2. Reject Claim");
			System.out.println("3. Settle Claim");
			System.out.println("4. Check Status");
			System.out.println("5. Exit");
			System.out.print("Choose option: ");

			String choiceInput = scanner.next();
			boolean choiceValid = true;
			for (int i = 0; i < choiceInput.length(); i++) {
				if (!Character.isDigit(choiceInput.charAt(i))) {
					choiceValid = false;
					break;
				}
			}

			if (!choiceValid) {
				System.out.println("Invalid choice. Enter number.");
				choice = 0;
				continue;
			}

			choice = Integer.parseInt(choiceInput);

			switch (choice) {

			case 1:
				System.out.print("Enter Approved Amount: ");
				String aInput = scanner.next();

				boolean aValid = true;
				int aDots = 0;
				for (int i = 0; i < aInput.length(); i++) {
					char ch = aInput.charAt(i);
					if (ch == '.') {
						aDots++;
						continue;
					}
					if (!Character.isDigit(ch)) {
						aValid = false;
						break;
					}
				}

				if (!aValid || aDots > 1
						|| (aInput.length() > 1 && aInput.startsWith("0") && !aInput.startsWith("0."))) {
					System.out.println("Invalid input. Enter a valid numeric amount without leading zeros.");
					break;
				}

				claim.approveClaim(Double.parseDouble(aInput));
				break;

			case 2:
				claim.rejectClaim();
				break;

			case 3:
				claim.settleClaim();
				break;

			case 4:
				System.out.println("Claim ID: " + claim.getClaimId());
				System.out.println("Status: " + claim.getClaimStatus());
				System.out.println("Claim Amount: " + claim.getClaimAmount());
				System.out.println("Approved Amount: " + claim.getApprovedAmount());
				break;

			case 5:
				System.out.println("Exited");
				break;

			default:
				System.out.println("Invalid option.");
			}

		} while (choice != 5);

		scanner.close();
	}
}