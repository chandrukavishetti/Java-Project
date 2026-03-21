package com.chandru.practice.model;

public class Car extends Vehicle {

	public Car(String brand, int speed) {
		super(brand, speed);

	}

	@Override
	public void move() {
		System.out.println("the bike brand is " + brand + " and bike speed is " + speed);
	}

}
