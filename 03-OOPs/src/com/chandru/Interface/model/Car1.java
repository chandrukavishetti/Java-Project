package com.chandru.Interface.model;

public class Car1 implements VehicleControl {

    private int currentGear = 0;

    @Override
    public void start() {
        System.out.println("Car started with key ignition.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    @Override
    public void changeGear(int gear) {

        if (gear < 1 || gear > 5) {
            System.out.println("Car supports gears between 1 and 5.");
            return;
        }

        currentGear = gear;
        System.out.println("Car gear changed to: " + currentGear);
    }
}