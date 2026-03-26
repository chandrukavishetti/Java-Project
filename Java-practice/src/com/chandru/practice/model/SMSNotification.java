package com.chandru.practice.model;

import com.chandru.practice.model.Notification;

public class SMSNotification extends Notification {

	@Override
	public void sendNotification(String message) {
		System.out.println("\nThis notification from the SMSNotification : " + message);
	}

}
