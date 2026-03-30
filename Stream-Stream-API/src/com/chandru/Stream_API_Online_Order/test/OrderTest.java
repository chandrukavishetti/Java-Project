package com.chandru.Stream_API_Online_Order.test;

import com.chandru.Stream_API_Online_Order.model.*;
import java.util.*;

public class OrderTest {
	public static void main(String[] args) {
		InputHandler input = new InputHandler();
		OrderService service = new OrderService();
		List<Order> list = new ArrayList<>();

		int n = input.getInt("Enter the number of Orders: ");

		for (int i = 0; i < n; i++) {
			System.out.println("\n--- Enter Order " + (i + 1) + " Details ---");
			// Inside your for loop in OrderTest.java:

			int id = input.getInt("Order ID: ");
			String name = input.getString("Customer Name: ");

			// Use the new specific category method here
			int category = input.getCategory("Select the category:");

			double amount = input.getDouble("Order Price: ");
			boolean status = input.getBoolean("Order Status");

			list.add(new Order(id, name, category, amount, status));
		}

		System.out.println("\n1. --- Completed Orders ---");
		service.getCompletedOrder(list).forEach(System.out::println);

		System.out.println("\n2. Total Revenue (Completed): " + service.getCompletedOrderRevenue(list));

		System.out.println("\n3. --- Grouped By Category ---");
		System.out.println(service.groupByCategroy(list));

		System.out.println("\n4. --- Highest Amount Order ---");
		service.getOrderWithHighestAmount(list).ifPresent(System.out::println);

		System.out.println("\n5. Number of Cancelled Orders: " + service.getAllCancelledOrder(list));

		System.out.println("\n6. --- Order ID to Amount Map ---");
		System.out.println(service.mapOfOrderIdAmount(list));

		System.out.println("\n7. --- Customers (Highest Spenders First) ---");
		service.getAllCustomerBasedOnAmountDescending(list).forEach(System.out::println);
	}
}

//package com.chandru.Stream_API_Online_Order.test;
//
//import com.chandru.Stream_API_Online_Order.model.*;
//
//import java.util.*;
//
//public class OrderTest {
//	public static void main(String[] args) {
//		InputHandler input=new InputHandler();
//		OrderService service=new OrderService();
//		
//		List<Order>list=new ArrayList<>();
//		int n=input.getInt("enter the number of Orders : ");
//		
//		for(int i=0;i<n;i++) {
//			System.out.println("\n enter the order "+(i+1)+" details ");
//			
//			int id=input.getInt("Order ID : ");
//			String name=input.getString("customer name : ");
//			int category=input.getInt("enter the catergory for (1.veg) (2.non-veg) ");
//			double amount =input.getDouble("enter the order price");
//			boolean status=input.getBoolean("enter the active status (Cancelled or Completed)");
//			
//			list.add(new Order(id,name,category,amount,status));
//		}
//			System.out.println("\n completed orders");
//			service.getCompletedOrder(list).forEach(System.out::println);
//			
//			System.out.println("total revenue completed orders");
//			service.getCompletedOrderRevenue(list);
//			
//			System.out.println("group order by section");
//			System.out.println(service.groupByCategroy(list));
//			
//			System.out.println("order with maximum amount");
//			service.getOrderWithHighestAmount(list);
//			
//			System.out.println(" counting the cancelled orders");
//			service.getAllCancelledOrder(list);
//			
//			System.out.println("map of orderId->amount");
//			service
//			
//			System.out.println("customer names based on order amount descending");
//			service.getAllCustomerBasedOnAmountDescending(list);
//	}
//
//}
//
////questions 
////1. get all completed orders  
////2. calculate total revenue from completed orders  
////3. group orders by category  
////4. find the order with maximum amount  
////5. count cancelled orders  
////6. generate a map of orderId -> amount  
////7. produce a sorted list of customer names based on order amount descending 