package com.chandru.abstract_interface_exception.model2;

public class DiagnosticTest extends HospitalService implements ServiceEligibility {

	public DiagnosticTest(int serviceId, String patientName, double consultationFee) {
		super(serviceId, patientName, consultationFee);
		System.out.println("DiagnosticTest constructor called");
	}

	@Override
	public double calculateTotalFee() {
		return consultationFee + 800;
	}

	@Override
	public boolean checkEligibility(double fee) {

		if (fee <= 2000) {
			return true;
		}

		return false;
	}
}