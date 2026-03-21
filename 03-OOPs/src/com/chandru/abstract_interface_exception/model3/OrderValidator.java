package com.chandru.abstract_interface_exception.model3;

public class OrderValidator {
	
	public void validate(double fee) throws InvalidOrderScenariosException{
		if(fee<=0) {
			throw new InvalidOrderScenariosException("amount must be positive");
		}
	}
	
	public int serviceType(int type) throws InvalidOrderScenariosException{
		if(type < 1 || type >3) {
			throw new InvalidOrderScenariosException("enter the number between 1 to 3");
		}
		return type;
		
	}

}
