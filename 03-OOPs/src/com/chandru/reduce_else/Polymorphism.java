package com.chandru.reduce_else;

class Vehicle {
    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike started");
    }
}

public class Polymorphism {
	public static void main(String[] args) {
		Vehicle vehicle=new Vehicle();
		vehicle.start();
	}

}
