package com.chandru.abstract_interface_exception.model3;

public abstract class GeneralOrder {
	
	protected int orderId;
	protected String customerName;
	protected double orderAmount;
	
	public GeneralOrder(int orderId,String customerName,double orderAmount) {
		this.orderId=orderId;
		this.customerName=customerName;
		this.orderAmount=orderAmount;
	}
	public abstract double calculateTotalOrderFee();
	
	public void displayOrder() {
		System.out.println("order Id : "+orderId);
		System.out.println("patient name : "+customerName);
		System.out.println("consultation fee  : "+orderAmount);
	}
	

}
