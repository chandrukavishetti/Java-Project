package com.chandru.abstract_interface_exception.model3;

public class InterNationalOrder extends GeneralOrder implements OrderVerification{
	
	public InterNationalOrder(int orderId,String customerName,double orderAmount) {
		super(orderId,customerName,orderAmount);
		System.out.println("international orders constuctor");
	}
	
	@Override
	public double calculateTotalOrderFee() {
		return orderAmount + 1000;
	}
	
	@Override
	public boolean checkOrderVerification(double fee) {
		
		if(fee <= 5000) {
			return true;
		}
		return false;
	}

}
