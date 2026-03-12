package com.chandru.assignment_test.model;

public class Bike extends Vehicle {

	private String bikeType;

	public Bike(int registrationNumber, String ownerName, double baseUsageCharge, String bikeType) {

		super(registrationNumber, ownerName, baseUsageCharge);

		VehicleValidator.ownerNameValidator(bikeType);

		this.bikeType = bikeType;
	}

	@Override
	public void displayVehicle() {

		System.out.println("\nBike Details");
		System.out.println("Registration No: " + getRegistrationNumber());
		System.out.println("Owner Name: " + getOwnerName());
		System.out.println("Base Charge: " + getBaseUsageCharge());
		System.out.println("Bike Type: " + bikeType);
	}
}