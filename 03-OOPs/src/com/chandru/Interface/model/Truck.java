package com.chandru.Interface.model;

public class Truck implements VehicleControl {

    private int currentGear = 0;

    @Override
    public void start() {
        System.out.println("Truck started with heavy ignition system.");
    }

    @Override
    public void stop() {
        System.out.println("Truck stopped.");
    }

    @Override
    public void changeGear(int gear) {

        if (gear < 1 || gear > 6) {
            System.out.println("Truck supports gears between 1 and 6.");
            return;
        }

        currentGear = gear;
        System.out.println("Truck gear changed to: " + currentGear);
    }
}