package com.chandru.Stream_API_Online_Order.model;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

	// 1. Get all completed orders
	public List<Order> getCompletedOrder(List<Order> list) {
		return list.stream().filter(Order::isCompleted).collect(Collectors.toList());
	}

	// 2. Calculate total revenue from completed orders
	public double getCompletedOrderRevenue(List<Order> list) {
		return list.stream().filter(Order::isCompleted).mapToDouble(Order::getAmount).sum();
	}

	// 3. Group orders by category 
	public Map<Integer, List<Order>> groupByCategroy(List<Order> list) {
		return list.stream().collect(Collectors.groupingBy(Order::getCategory));
	}

	// 4. Find the order with maximum amount
	public Optional<Order> getOrderWithHighestAmount(List<Order> list) {
		return list.stream().max(Comparator.comparingDouble(Order::getAmount));
	}

	// 5. Count cancelled orders
	public long getAllCancelledOrder(List<Order> list) {
		return list.stream().filter(o -> !o.isCompleted()).count();
	}

	// 6. Generate a map of orderId -> amount
	public Map<Integer, Double> mapOfOrderIdAmount(List<Order> list) {
		return list.stream().collect(Collectors.toMap(Order::getOrderId, Order::getAmount));
	}

	// 7. Sorted list of customer names based on amount descending
	public List<String> getAllCustomerBasedOnAmountDescending(List<Order> list) {
		return list.stream().sorted(Comparator.comparingDouble(Order::getAmount).reversed()).map(Order::getCustomerName)
				.collect(Collectors.toList());
	}
}
//
//
//package com.chandru.Stream_API_Online_Order.model;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//import com.chandru.Stream_API_Student_Result.model.Student;
//
//public class OrderService {
//	//1.get all completed order
//	public List<Order>getCompletedOrder(List<Order>list){
//		return list.stream().filter(Order::getStatus).collect(Collectors.toList());
//	}
//	//2.get all completed order revenue
//	public List<Order>getCompletedOrderRevenue(List<Order>list){
//		return list.stream().filter(o->o.getStatus().equalsIgnoreCase("Completed")).collect(Collectors.toList());
//	}
//	//3.group order by category
//	public Map<int,List<Order>>groupByCategroy(List<Student>list){
//		return list.stream().collect(Collectors.groupingBy(Order::getCategroy));
//	}
//	//4.find the order with maximum amount
//	public Optional<Order> getOrderWithHighestAmount(List<Order>list){
//		return list.stream().max(Comparator.comparing(Order::getAmount));
//	}
//	//5.Count cancelled orders 
//	public List<Order> getAllCancelledOrder(List<Order>list){
//		return list.stream().filter(o->o.getStatus().equalsIgnoreCase("Cancelled")).count());
//	}
//	//6.generate the map of orderId->amount
//	public Map<int,double> mapOfOrderIdAmount(List<Order>list){
//		return list.stream().collect(Collectors.groupingBy(Order::getOrderId,Collectors.toList()));
//	}
//	//7. produce a sorted list of customer names based on order amount descending  
//	public List<Order> getAllCustomerBasedOnAmountDescending (List<Order>list){
//		return list.stream().sorted(Collectors.comparing(Order::getAmount).reversed()).map(Order::getName).collect(Collectors.toList());
//	}
//
//}
