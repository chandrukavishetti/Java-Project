package com.chandru.Interface.model;

public class Bike1 implements VehicleControl {

    private int currentGear = 0;

    @Override
    public void start() {
        System.out.println("Bike started with self-start.");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped.");
    }

    @Override
    public void changeGear(int gear) {

        if (gear < 1 || gear > 4) {
            System.out.println("Bike supports gears between 1 and 4.");
            return;
        }

        currentGear = gear;
        System.out.println("Bike gear changed to: " + currentGear);
    }
}