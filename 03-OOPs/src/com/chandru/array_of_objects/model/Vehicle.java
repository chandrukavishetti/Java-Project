package com.chandru.array_of_objects.model;

public class Vehicle {

	protected String vehicleNumber;

	protected static int totalVehiclesProcessed = 0;
	protected static double totalTollCollected = 0;

	public Vehicle(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
		totalVehiclesProcessed++;
	}

	public double calculateToll() {
		return 0;
	}

	public double calculateToll(double amount) {
		totalTollCollected += amount;
		return amount;
	}

	public static int getTotalVehiclesProcessed() {
		return totalVehiclesProcessed;
	}

	public static double getTotalTollCollected() {
		return totalTollCollected;
	}

	public void displayVehicle() {
		System.out.println("-------------------------------");
		System.out.println("Vehicle Number : " + vehicleNumber);
	}
}
