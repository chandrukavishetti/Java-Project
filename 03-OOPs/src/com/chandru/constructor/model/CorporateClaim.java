package com.chandru.constructor.model;

public class CorporateClaim extends InsuranceClaim {

	private static final double PROCESSING_FEE = 500;

	public CorporateClaim(String policyNumber, double claimAmount) {

		super(policyNumber, claimAmount); // Parent constructor must run first

		this.approvedAmount = -PROCESSING_FEE;
	}
}
