package com.chandru.Inventory_mng_sys.model;

public class SMSNotifier implements Notifier {
    public void notifyUser(String message) {
        System.out.println("[SMS] " + message);
    }
}