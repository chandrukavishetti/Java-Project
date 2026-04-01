package com.chandru.SRP.IOT_Smart_Home_Sys.test;

import com.chandru.SRP.IOT_Smart_Home_Sys.model.*;
import java.util.HashMap;
import java.util.Map;

public class DeviceTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();

		int id = input.getInt("Enter Device ID: ");
		String name = input.getString("Enter Device Name: ");

		Map<String, String> config = new HashMap<>();
		config.put("mode", "AUTO");

		Device device = new Device(id, name, false, config);

		DeviceManager manager = new DeviceManager();
		LoggerService logger = new LoggerService();
		APIService api = new APIService();
		AlertService alert = new AlertService();

		manager.turnOn(device);
		logger.log("Device turned ON");

		String key = input.getString("Enter setting key: ");
		String value = input.getString("Enter setting value: ");
		manager.updateSetting(device, key, value);
		logger.log("Configuration updated");

		api.sendData(device);

		alert.sendAlert("Device is running smoothly");

		System.out.println("\n----- Device Details -----");
		System.out.println("ID: " + device.getDeviceId());
		System.out.println("Name: " + device.getDeviceName());
		System.out.println("Status: " + (device.isStatus() ? "ON" : "OFF"));
		System.out.println("Configuration: " + device.getConfiguration());
	}
}