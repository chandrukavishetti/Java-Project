package com.chandru.array_of_objects.model;

public class Truck extends Vehicle {

    private double baseRate;
    private double loadCharge;

    public Truck(String vehicleNumber, double baseRate, double loadCharge) {
        super(vehicleNumber);
        this.baseRate = baseRate;
        this.loadCharge = loadCharge;
    }

    @Override
    public double calculateToll() {
        return calculateToll(baseRate + loadCharge);
    }
}