package com.chandru.abstract_interface_exception.test3;

import com.chandru.abstract_interface_exception.model3.OrderConfig;
import com.chandru.abstract_interface_exception.model3.OrderServiceSystem;

public class OnlineOrderFullfillment {
	public static void main(String[] args) {
		new OrderConfig();
		OrderServiceSystem order=new OrderServiceSystem();
		order.startOrderProcessing();
		
	}

}
