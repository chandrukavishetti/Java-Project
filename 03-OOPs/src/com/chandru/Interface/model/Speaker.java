package com.chandru.Interface.model;

public class Speaker implements Controllable {
	@Override
	public void turnOn() {
		System.out.println("speaker turned on");
	}

	@Override
	public void turnOff() {
		System.out.println("speaker turned off");
	}

	@Override
	public void setMode(String mode) {
		System.out.println("speaker sound made set to : " + mode);
	}

}
