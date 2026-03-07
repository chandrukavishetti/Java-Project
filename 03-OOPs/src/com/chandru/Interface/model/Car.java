package com.chandru.Interface.model;

public class Car implements Vehicle {
	private String fuel;

	public Car(String fuel) {
		this.fuel = fuel;
	}

	@Override
	public void start() {
		System.out.println("car is started");
	}

	@Override
	public void stop() {
		System.out.println("car is stoped");
	}

	@Override
	public String fuelType() {
		return fuel;
	}

}
