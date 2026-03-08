package com.chandru.abstract_class.model;

public abstract class Patient {
	private int patientId;
	private String name;

	public Patient(int patientID, String name) {
		this.patientId = patientID;
		this.name = name;
	}

	public int getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public void generateBill() {
		double charges = calculateCharges();
		double tax = charges * 0.05;
		double finalAmount = charges + tax;

		System.out.println("\n=======bill receipt====");
		System.out.println("patient id    : " + patientId);
		System.out.println("patient name  : " + name);
		System.out.println("base charges  : " + charges);
		System.out.println("tax (5%)      : " + tax);
		System.out.println("Final Amount  : " + finalAmount);
		System.out.println("========================");
	}

	public abstract double calculateCharges();
}
