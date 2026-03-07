package com.chandru.abstract_class.test;

import java.util.Scanner;
import com.chandru.abstract_class.model.Patient;
import com.chandru.abstract_class.model.OutPatient;
import com.chandru.abstract_class.model.InPatient;
import com.chandru.abstract_class.model.EmergencyPatient;

public class PatientTest {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Patient[] patients = new Patient[3];

		patients[0] = createInPatient();
		patients[1] = createOutPatient();
		patients[2] = createEmergencyPatient();

		System.out.println("\n===== GENERATING BILLS =====");

		for (Patient patient : patients) {
			patient.generateBill();
		}
	}

	public static int getValidPatientId() {
		int id = 0;
		boolean valid = false;

		while (!valid) {
			System.out.print("Enter Patient ID: ");

			if (scanner.hasNextInt()) {
				id = scanner.nextInt();

				if (id > 0) {
					valid = true;
				} else {
					System.out.println("Patient ID must be greater than 0.");
				}
			} else {
				System.out.println("Invalid Input! Enter numeric value only.");
				scanner.next();
			}
		}
		return id;
	}

	public static String getValidName() {
		String name = "";
		boolean valid = false;

		while (!valid) {
			System.out.print("Enter Patient Name: ");
			name = scanner.next();

			if (name.matches("[a-zA-Z]+")) {
				valid = true;
			} else {
				System.out.println("Invalid Name! Only alphabets allowed.");
			}
		}
		return name;
	}

	public static double getValidAmount(String message) {
		double amount = 0;
		boolean valid = false;

		while (!valid) {
			System.out.print(message);

			if (scanner.hasNextDouble()) {
				amount = scanner.nextDouble();

				if (amount > 0) {
					valid = true;
				} else {
					System.out.println("Amount must be greater than 0.");
				}
			} else {
				System.out.println("Invalid Input! Enter numeric value only.");
				scanner.next();
			}
		}
		return amount;
	}

	public static int getValidDays() {
		int days = 0;
		boolean valid = false;

		while (!valid) {
			System.out.print("Enter Number of Days: ");

			if (scanner.hasNextInt()) {
				days = scanner.nextInt();

				if (days > 0) {
					valid = true;
				} else {
					System.out.println("Days must be greater than 0.");
				}
			} else {
				System.out.println("Invalid Input! Enter numeric value only.");
				scanner.next();
			}
		}
		return days;
	}

	public static Patient createInPatient() {
		System.out.println("\n--- In Patient ---");
		int id = getValidPatientId();
		String name = getValidName();
		double roomCharge = getValidAmount("Enter Room Charge per Day: ");
		int days = getValidDays();

		return new InPatient(id, name, roomCharge, days);
	}

	public static Patient createOutPatient() {
		System.out.println("\n--- Out Patient ---");
		int id = getValidPatientId();
		String name = getValidName();
		double fee = getValidAmount("Enter Consultation Fee: ");

		return new OutPatient(id, name, fee);
	}

	public static Patient createEmergencyPatient() {
		System.out.println("\n--- Emergency Patient ---");
		int id = getValidPatientId();
		String name = getValidName();
		double charge = getValidAmount("Enter Emergency Charge: ");

		return new EmergencyPatient(id, name, charge);
	}
}