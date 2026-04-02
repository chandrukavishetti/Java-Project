package com.chandru.ISP.Food_Delivery_Platform.test;

import com.chandru.ISP.Food_Delivery_Platform.model.*;

public class FoodDeliveryTest {

    public static void main(String[] args) {

        InputHandler input = new InputHandler();

        System.out.println("1. Customer");
        System.out.println("2. Restaurant Owner");

        int choice = input.getInt("Enter your role: ");

        switch (choice) {

            case 1:
                CustomerOperations customer = new Customer();

                String item = input.getString("Enter item to order: ");
                customer.placeOrder(item);

                int orderId = input.getInt("Enter order ID to track: ");
                customer.trackOrder(orderId);

                int rating = input.getInt("Rate driver (1-5): ");
                customer.rateDriver(rating);
                break;

            case 2:
                RestaurantOperations owner = new RestaurantOwner();

                String action = input.getString("Enter action (Add/Remove/Update menu): ");
                owner.manageRestaurant(action);
                break;

            default:
                System.out.println(" Invalid choice!");
        }
    }
}