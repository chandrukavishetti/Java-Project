package com.chandru.abstract_class.model;

public class EmergencyPatient extends Patient {

	private double emergencyCharge;

	public EmergencyPatient(int patientId, String name, double emergencyCharge) {
		super(patientId, name);
		this.emergencyCharge = emergencyCharge;
	}

	@Override
	public double calculateCharges() {
		return emergencyCharge + 1000; 
	}
}