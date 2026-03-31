package com.chandru.SRP.HealthCare.model;

public class PatientService {

	private Patient patient;

	public void addPatient(Patient patient) {
		this.patient = patient;
		System.out.println("patient added successfully");
	}

	public Patient getPatient() {
		return patient;
	}

}
