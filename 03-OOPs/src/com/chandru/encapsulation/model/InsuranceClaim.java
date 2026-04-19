package com.chandru.encapsulation.model;

public class InsuranceClaim {

	public enum ClaimStatus {
		FILED, APPROVED, REJECTED, SETTLED
	}

	private static int idCounter = 100;
	private final int claimId;
	private String policyNumber;
	private double claimAmount;
	private double approvedAmount;
	private ClaimStatus claimStatus;

	public InsuranceClaim(String policyNumber, double claimAmount) {

		if (policyNumber == null || policyNumber.trim().isEmpty()) {
			System.out.println("Invalid policy number");
		}

		if (claimAmount < 0) {
			System.out.println("Claim amount cannot be negative");
		}

		this.claimId = ++idCounter;
		this.policyNumber = policyNumber;
		this.claimAmount = claimAmount;
		this.claimStatus = ClaimStatus.FILED;
		this.approvedAmount = 0;
	}

	public int getClaimId() {
		return claimId;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}

	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}

	public void approveClaim(double amount) {

		if (claimStatus != ClaimStatus.FILED) {
			System.out.println("Claim can only be approved from FILED state.");
			return;
		}

		if (amount < 0 || amount > claimAmount) {
			System.out.println("Invalid approved amount.");
			return;
		}

		this.approvedAmount = amount;
		this.claimStatus = ClaimStatus.APPROVED;
		System.out.println("Claim Approved.");
	}

	public void rejectClaim() {

		if (claimStatus != ClaimStatus.FILED) {
			System.out.println("Claim can only be rejected from FILED state.");
			return;
		}

		this.claimStatus = ClaimStatus.REJECTED;
		System.out.println("Claim Rejected.");
	}

	public void settleClaim() {

		if (claimStatus != ClaimStatus.APPROVED) {
			System.out.println("Only APPROVED claim can be settled.");
			return;
		}

		this.claimStatus = ClaimStatus.SETTLED;
		System.out.println("Claim Settled.");
	}
}
