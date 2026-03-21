package com.chandru.practice.model;

public class Bike extends Vehicle {

	public Bike(String brand, int speed) {
		super(brand, speed);

	}

	public void move() {
		System.out.println("the bike brand is : " + brand + " and speed is : " + speed);
	}

}
