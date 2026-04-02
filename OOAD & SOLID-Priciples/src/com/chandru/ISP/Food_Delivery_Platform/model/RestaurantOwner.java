package com.chandru.ISP.Food_Delivery_Platform.model;

public class RestaurantOwner implements RestaurantOperations {

    @Override
    public void manageRestaurant(String action) {
        System.out.println(" Restaurant action: " + action);
    }
}