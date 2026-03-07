package com.chandru.array_of_objects.test;

import java.util.Scanner;
import com.chandru.array_of_objects.model.*;

public class TollTest {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Vehicle[] vehicles = new Vehicle[5];

		for (int i = 0; i < vehicles.length; i++) {

			System.out.println("\nEnter details for Vehicle " + (i + 1));

			String vehicleNumber = readValidVehicleNumber();

			System.out.println("Select Vehicle Type:");
			System.out.println("1. Car");
			System.out.println("2. Truck");
			System.out.println("3. Motorcycle");

			int choice = readChoice();

			switch (choice) {

			case 1:
				double carRate = readPositiveDouble("Enter Car Toll Rate: ");
				vehicles[i] = new Car(vehicleNumber, carRate);
				break;

			case 2:
				double truckRate = readPositiveDouble("Enter Truck Base Rate: ");
				double loadCharge = readPositiveDouble("Enter Load Charge: ");
				vehicles[i] = new Truck(vehicleNumber, truckRate, loadCharge);
				break;

			case 3:
				double bikeRate = readPositiveDouble("Enter Motorcycle Toll Rate: ");
				vehicles[i] = new Motorcycle(vehicleNumber, bikeRate);
				break;
			}
		}

		System.out.println("\n===== Toll Details =====");

		for (Vehicle vehicle : vehicles) {
			vehicle.displayVehicle();
			System.out.println("Toll Amount : " + vehicle.calculateToll());
		}

		System.out.println("\nTotal Vehicles Processed : " + Vehicle.getTotalVehiclesProcessed());
		System.out.println("Total Toll Collected     : " + Vehicle.getTotalTollCollected());
	}

	private static String readValidVehicleNumber() {

		String number = "";
		boolean valid = false;

		while (!valid) {

			System.out.print("Enter Vehicle Number: ");
			number = scanner.nextLine().trim();

			if (number.isEmpty()) {
				System.out.println("Vehicle number cannot be blank.");
				continue;
			}

			boolean invalid = false;

			for (int i = 0; i < number.length(); i++) {

				char ch = number.charAt(i);

				if (!Character.isLetterOrDigit(ch)) {
					invalid = true;
					break;
				}
			}

			if (!invalid) {
				valid = true;
			} else {
				System.out.println(
						"Vehicle number should contain only alphabets and numbers. No special symbols allowed.");
			}
		}

		return number;
	}

	private static double readPositiveDouble(String message) {

		double value = 0;
		boolean valid = false;

		while (!valid) {

			System.out.print(message);

			if (scanner.hasNextDouble()) {
				value = scanner.nextDouble();
				scanner.nextLine();

				if (value >= 0) {
					valid = true;
				} else {
					System.out.println("Value cannot be negative.");
				}

			} else {
				System.out.println("Invalid input. Enter numeric value only.");
				scanner.nextLine();
			}
		}

		return value;
	}

	private static int readChoice() {

		int choice = 0;
		boolean valid = false;

		while (!valid) {

			System.out.print("Enter choice (1-3): ");

			if (scanner.hasNextInt()) {

				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
				case 2:
				case 3:
					valid = true;
					break;
				default:
					System.out.println("Invalid choice. Select 1, 2 or 3.");
				}

			} else {
				System.out.println("Enter numbers only.");
				scanner.nextLine();
			}
		}

		return choice;
	}
}