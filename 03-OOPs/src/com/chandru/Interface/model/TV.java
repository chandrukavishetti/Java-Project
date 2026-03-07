package com.chandru.Interface.model;

public class TV implements Controllable {
	@Override
	public void turnOn() {
		System.out.println("tv turned on");
	}

	@Override
	public void turnOff() {
		System.out.println("tv turned off");
	}

	@Override
	public void setMode(String mode) {
		System.out.println("tv display mode set to: " + mode);
	}
}
