package com.chandru.ISP.Food_Delivery_Platform.model;

public class Customer implements CustomerOperations {

	@Override
	public void placeOrder(String item) {
		System.out.println(" Order placed for: " + item);
	}

	@Override
	public void trackOrder(int orderId) {
		System.out.println(" Tracking order ID: " + orderId);
	}

	@Override
	public void rateDriver(int rating) {
		System.out.println(" Driver rated: " + rating + "/5");
	}
}