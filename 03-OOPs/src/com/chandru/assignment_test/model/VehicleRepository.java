package com.chandru.assignment_test.model;

public class VehicleRepository {

	private Vehicle[] vehicles;
	private int index = 0;

	public VehicleRepository(int size) {
		vehicles = new Vehicle[size];
	}

	public void addVehicle(Vehicle vehicle) {

		if (index < vehicles.length) {
			vehicles[index++] = vehicle;
		} else {
			System.out.println("Vehicle storage full");
		}
	}

	public Vehicle[] getAllVehicles() {
		return vehicles;
	}
}