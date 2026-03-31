package com.chandru.SRP.HealthCare.test;

import com.chandru.SRP.HealthCare.model.*;

public class PatientTest {
	public static void main(String[] args) {

		InputHandler input = new InputHandler();

		int id = input.getInt("Enter Patient ID: ");
		String name = input.getString("Enter Patient Name: ");
		int age = input.getInt("Enter Patient Age: ");
		String disease = input.getString("Enter Disease: ");
		int mobileNumber = input.getInt("Enter Mobile Number: ");

		Patient patient = new Patient(id, name, age, disease, mobileNumber);

		PatientService service = new PatientService();
		NotificationService notification = new NotificationService();
		PatientFormatter formatter = new PatientFormatter();

		service.addPatient(patient);

		Patient storedPatient = service.getPatient();

		notification.sendNotification(storedPatient);

		formatter.printPatient(storedPatient);
	}
}