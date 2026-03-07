package com.chandru.array_of_objects.model;

public class Motorcycle extends Vehicle {

    private double baseRate;

    public Motorcycle(String vehicleNumber, double baseRate) {
        super(vehicleNumber);
        this.baseRate = baseRate;
    }

    @Override
    public double calculateToll() {
        return calculateToll(baseRate);
    }
}