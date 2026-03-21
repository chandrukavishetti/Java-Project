package com.chandru.abstract_interface_exception.model3;

public class StandardOrder extends GeneralOrder implements OrderVerification{
	
	public StandardOrder(int orderId,String customerName,double orderAmount) {
		super(orderId,customerName,orderAmount);
		System.out.println("standard order constructor");
	}
	
	@Override
	public double calculateTotalOrderFee() {
		return orderAmount+200;
	}
	
	@Override
	public boolean checkOrderVerification(double fee) {
		
		if(fee <= 500) {
			return true;
		}
		return false;
	}

}
