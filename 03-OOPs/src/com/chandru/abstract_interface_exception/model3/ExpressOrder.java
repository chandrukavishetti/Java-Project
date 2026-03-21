package com.chandru.abstract_interface_exception.model3;

public class ExpressOrder extends GeneralOrder implements OrderVerification{
	
	public ExpressOrder(int orderId,String customerName,double orderAmount) {
		
		super(orderId,customerName,orderAmount);
		System.out.println("Express order constructor");
	}
	
	@Override
	public double calculateTotalOrderFee() {
		return orderAmount+500;
	}
	
	@Override
	public boolean checkOrderVerification(double fee) {
		
		if(fee <= 2000) {
			return true;
		}
		return false;
	}

}
