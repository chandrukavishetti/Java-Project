package com.chandru.abstract_class.model;

public class OutPatient extends Patient {
	private double consultationFee;

	public OutPatient(int patientId, String name, double consultationFee) {
		super(patientId, name);
		this.consultationFee = consultationFee;
	}

	@Override
	public double calculateCharges() {
		return consultationFee;
	}

}
