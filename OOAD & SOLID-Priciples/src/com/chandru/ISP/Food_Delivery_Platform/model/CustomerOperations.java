package com.chandru.ISP.Food_Delivery_Platform.model;

public interface CustomerOperations {
    void placeOrder(String item);
    void trackOrder(int orderId);
    void rateDriver(int rating);
}