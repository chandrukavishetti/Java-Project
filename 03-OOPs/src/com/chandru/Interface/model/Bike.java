package com.chandru.Interface.model;

public class Bike implements Vehicle {
	@Override
	public void start() {
		System.out.println("bike is stated");
	}

	@Override
	public void stop() {
		System.out.println("bike stoped");

	}

	@Override
	public String fuelType() {
		return "Petrol";
	}

}
