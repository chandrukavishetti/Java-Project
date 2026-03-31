package com.chandru.SRP.HealthCare.model;

public class PatientFormatter {

	public void printPatient(Patient patient) {
		System.out.println("\n----- Patient Details -----");
		System.out.println("ID: " + patient.getId());
		System.out.println("Name: " + patient.getName());
		System.out.println("Age: " + patient.getAge());
		System.out.println("Disease: " + patient.getDisease());
		System.out.println("Mobile No: " + patient.getMobileNo());
	}
}