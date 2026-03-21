package com.chandru.abstract_interface_exception.model2;

public class Surgery extends HospitalService implements ServiceEligibility {

	public Surgery(int serviceId, String patientName, double consultationFee) {
		super(serviceId, patientName, consultationFee);
		System.out.println("Surgery constructor called");
	}

	@Override
	public double calculateTotalFee() {
		return consultationFee + 5000;
	}

	@Override
	public boolean checkEligibility(double fee) {

		if (fee >= 1000) {
			return true;
		}

		return false;
	}
}