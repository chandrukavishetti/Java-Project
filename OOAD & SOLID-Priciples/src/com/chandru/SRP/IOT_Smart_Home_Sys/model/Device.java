package com.chandru.SRP.IOT_Smart_Home_Sys.model;

import java.util.Map;

public class Device {

	private int deviceId;
	private String deviceName;
	private boolean status; // true = ON, false = OFF
	private Map<String, String> configuration;

	public Device(int deviceId, String deviceName, boolean status, Map<String, String> configuration) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.status = status;
		this.configuration = configuration;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Map<String, String> getConfiguration() {
		return configuration;
	}
}