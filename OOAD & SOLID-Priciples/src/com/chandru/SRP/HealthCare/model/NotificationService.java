package com.chandru.SRP.HealthCare.model;

public class NotificationService {
	public void sendNotification(Patient patient) {
		System.out
				.println("notification sent to " + patient.getName() + " on mobile number : " + patient.getMobileNo());
	}

}
