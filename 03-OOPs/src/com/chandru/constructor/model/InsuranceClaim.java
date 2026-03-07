package com.chandru.constructor.model;

public class InsuranceClaim {
	private static int idCounter = 1000;

	private final int claimId;
	private String policyNumber;
	private double claimAmount;
	private String status;
	protected double approvedAmount;

	public InsuranceClaim(String policyNumber, double claimAmount) {

		if (policyNumber == null || policyNumber.trim().isEmpty()) {
			System.out.println("Invalid policy number");
		}

		if (claimAmount < 0) {
			System.out.println("claim amount cannot be negative");
		}

		this.claimId = ++idCounter;
		this.policyNumber = policyNumber;
		this.claimAmount = claimAmount;
		this.status = "FILED";
		this.approvedAmount = 0;
	}

	public int getClaimId() {
		return claimId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public String getStatus() {
		return status;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}
}
