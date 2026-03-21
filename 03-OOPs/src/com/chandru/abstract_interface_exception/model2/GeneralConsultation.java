package com.chandru.abstract_interface_exception.model2;

public class GeneralConsultation extends HospitalService implements ServiceEligibility {

	public GeneralConsultation(int serviceId, String patientName, double consultationFee) {
		super(serviceId, patientName, consultationFee);
		System.out.println("GeneralConsultation constructor called");
	}

	@Override
	public double calculateTotalFee() {
		return consultationFee + 200;
	}

	@Override
	public boolean checkEligibility(double fee) {

		if (fee <= 500) {
			return true;
		}

		return false;
	}
}