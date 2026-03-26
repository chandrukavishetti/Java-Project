package com.chandru.practice.model;

import com.chandru.practice.model.Notification;

public class PushNotification extends Notification {

	@Override
	public void sendNotification(String message) {
		System.out.println("this message form the PushNotification : " + message);
	}

}
