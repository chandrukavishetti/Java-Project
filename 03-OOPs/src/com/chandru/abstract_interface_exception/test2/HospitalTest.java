package com.chandru.abstract_interface_exception.test2;

import com.chandru.abstract_interface_exception.model2.HospitalConfig;
import com.chandru.abstract_interface_exception.model2.HospitalServiceManager;

public class HospitalTest {

	public static void main(String[] args) {

		new HospitalConfig();

		HospitalServiceManager manager = new HospitalServiceManager();

		manager.startServiceProcessing();
	}
}