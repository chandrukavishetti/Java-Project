package com.chandru.practice.test;

import com.chandru.practice.model.Notification;
import com.chandru.practice.model.PushNotification;
import com.chandru.practice.model.SMSNotification;
import com.chandru.practice.model.EmailNotification;

public class NotificationTest {
	public static void main(String[] args) {
		Notification[] notifications = new Notification[3];

		notifications[0] = new PushNotification();
		notifications[1] = new SMSNotification();
		notifications[2] = new EmailNotification();

		String messageToAll = "hello to all i am arrived as a java developer";

		for (Notification n : notifications) {
			n.sendNotification(messageToAll);
		}
	}

}
