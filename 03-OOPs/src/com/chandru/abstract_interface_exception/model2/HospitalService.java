package com.chandru.abstract_interface_exception.model2;

public abstract class HospitalService {

	protected int serviceId;
	protected String patientName;
	protected double consultationFee;

	public HospitalService(int serviceId, String patientName, double consultationFee) {
		this.serviceId = serviceId;
		this.patientName = patientName;
		this.consultationFee = consultationFee;
	}

	public abstract double calculateTotalFee();

	public void displayService() {
		System.out.println("Service ID: " + serviceId);
		System.out.println("Patient Name: " + patientName);
		System.out.println("Consultation Fee: " + consultationFee);
	}
}