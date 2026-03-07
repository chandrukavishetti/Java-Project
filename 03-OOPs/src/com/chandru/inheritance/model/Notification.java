package com.chandru.inheritance.model;

public class Notification {

	protected String recipient;
	protected String message;

	public Notification(String recipient, String message) {
		this.recipient = recipient;
		this.message = message;
	}

	public void logNotification() {
		System.out.println("\n[LOG] Preparing notification for: " + recipient);
	}

	public void send() {
		System.out.println("Sending notification...");
	}
}
