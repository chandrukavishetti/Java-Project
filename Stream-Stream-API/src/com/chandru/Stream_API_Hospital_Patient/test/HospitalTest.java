package com.chandru.Stream_API_Hospital_Patient.test;

import java.util.*;

import com.chandru.Stream_API_Hospital_Patient.model.*;

public class HospitalTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();
		PatientService service = new PatientService();

		List<Patient> list = new ArrayList<>();

		int n = input.getInt("Enter number of patients: ");

		for (int i = 0; i < n; i++) {
			System.out.println("\n--- Enter Patient " + (i + 1) + " Details ---");

			int id = input.getInt("ID: ");
			String name = input.getString("Name: ");
			int age = input.getInt("Age: ");
			String disease = input.getString("Disease: ");
			boolean admitted = input.getBoolean("Admitted Status");
			double amount = input.getDouble("Bill Amount: ");

			list.add(new Patient(id, name, age, disease, admitted, amount));
		}

		// 1
		System.out.println("\n--- Admitted Patients ---");
		service.getAdmittedPatients(list).forEach(System.out::println);

		// 2
		System.out.println("\n--- Group By Disease ---");
		System.out.println(service.getGroupByDisease(list));

		// 3
		System.out.println("\n--- Admitted vs Non-Admitted ---");
		System.out.println(service.getAdmittedVsNonAdmitted(list));

		// 4
		System.out.println("\n--- Highest Bill Patient ---");
		service.getPatientWithHighestBill(list).ifPresent(System.out::println);

		// 5
		System.out.println("\n--- Average Bill Amount ---");
		System.out.println(service.getAverageBillAmount(list));

		// 6
		System.out.println("\n--- Patients Above Age 60 ---");
		service.getPatientNamesAbove60(list).forEach(System.out::println);

		// 7
		System.out.println("\n--- Disease -> Patient Names ---");
		System.out.println(service.getDiseaseToPatientNames(list));
	}
}