package com.chandru.abstract_interface_exception.model1;

public class SystemConfig {

	public static String bankName;

	static {
		bankName = "Chandrashekhar Finance Bank";
		System.out.println("System Configuration Loaded for: " + bankName);
	}
}