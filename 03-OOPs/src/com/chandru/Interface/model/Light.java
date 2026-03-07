package com.chandru.Interface.model;

public class Light implements Controllable {
	@Override
	public void turnOn() {
		System.out.println("Light turned on");
	}

	@Override
	public void turnOff() {
		System.out.println("light turn off");
	}

	@Override
	public void setMode(String mode) {
		System.out.println("light mode set to : " + mode);
	}

}
