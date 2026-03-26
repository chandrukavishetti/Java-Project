package com.chandru.practice.model;

import com.chandru.practice.model.Notification;

public class EmailNotification extends Notification {

	@Override
	public void sendNotification(String message) {
		System.out.println("\nThis notification is from the email : " + message);
	}

}
