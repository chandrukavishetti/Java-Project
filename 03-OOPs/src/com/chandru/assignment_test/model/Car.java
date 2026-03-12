package com.chandru.assignment_test.model;

public class Car extends Vehicle {

	private String carModel;

	public Car(int registrationNumber, String ownerName, double baseUsageCharge, String carModel) {

		super(registrationNumber, ownerName, baseUsageCharge);

		VehicleValidator.ownerNameValidator(carModel);

		this.carModel = carModel;
	}

	@Override
	public void displayVehicle() {

		System.out.println("\nCar Details");
		System.out.println("Registration No: " + getRegistrationNumber());
		System.out.println("Owner Name: " + getOwnerName());
		System.out.println("Base Charge: " + getBaseUsageCharge());
		System.out.println("Car Model: " + carModel);
	}
}