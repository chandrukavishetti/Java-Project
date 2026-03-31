package com.chandru.Inventory_mng_sys.model;

public class EmailNotifier implements Notifier {
	public void notifyUser(String message) {
		System.out.println("[EMAIL] " + message);
	}
}