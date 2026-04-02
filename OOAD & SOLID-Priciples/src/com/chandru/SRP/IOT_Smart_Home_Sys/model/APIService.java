package com.chandru.SRP.IOT_Smart_Home_Sys.model;

public class APIService {

	public void sendData(Device device) {
		System.out.println("Sending data of device: " + device.getDeviceName() + " to cloud...");
	}
}