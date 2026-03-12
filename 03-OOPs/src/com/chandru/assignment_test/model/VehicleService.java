package com.chandru.assignment_test.model;

public class VehicleService {

	private VehicleRepository repository;

	public VehicleService(VehicleRepository repository) {
		this.repository = repository;
	}

	public void addVehicle(Vehicle vehicle) {
		repository.addVehicle(vehicle);
	}

	public void displayVehicles() {

		Vehicle[] list = repository.getAllVehicles();

		for (Vehicle v : list) {

			if (v != null) {
				v.displayVehicle();
			}
		}
	}
}