package com.chandru.Interface.model;

public class Fan implements Controllable {
	@Override
	public void turnOn() {
		System.out.println("fan turned on");
	}

	@Override
	public void turnOff() {
		System.out.println("fan turned off");
	}

	@Override
	public void setMode(String mode) {
		System.out.println("fan speed set to : " + mode);
	}
}
