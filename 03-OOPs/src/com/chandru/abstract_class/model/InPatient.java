package com.chandru.abstract_class.model;

public class InPatient extends Patient {
	private double roomCharge;
	private int numberOfDays;

	public InPatient(int patientId, String name, double roomCharge, int numberOfDays) {
		super(patientId, name);
		this.roomCharge = roomCharge;
		this.numberOfDays = numberOfDays;
	}

	@Override
	public double calculateCharges() {
		return roomCharge * numberOfDays;
	}
}
