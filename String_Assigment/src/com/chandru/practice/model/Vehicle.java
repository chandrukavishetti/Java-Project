package com.chandru.practice.model;

public class Vehicle {
	protected String brand;
	protected int speed;

	public Vehicle(String brand, int speed) {
		this.brand = brand;
		this.speed = speed;
	}
	public void move() {
		System.out.println("this is main class vehical ");
	}
}