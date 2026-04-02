package com.chandru.SRP.IOT_Smart_Home_Sys.model;

public class DeviceManager {

	public void turnOn(Device device) {
		device.setStatus(true);
		System.out.println("Device turned ON");
	}

	public void turnOff(Device device) {
		device.setStatus(false);
		System.out.println(" Device turned OFF");
	}

	public void updateSetting(Device device, String key, String value) {
		device.getConfiguration().put(key, value);
		System.out.println(" Configuration updated: " + key + " = " + value);
	}
}