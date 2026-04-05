package com.chandru.Stream_API_Product_Inventory.model;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

	// 1. Find out-of-stock products
	public List<Product> getOutOfStockProducts(List<Product> list) {
		return list.stream().filter(p -> p.getStock() == 0).collect(Collectors.toList());
	}

	// 2. Group by category
	public Map<String, List<Product>> getGroupByCategory(List<Product> list) {
		return list.stream().collect(Collectors.groupingBy(Product::getCategory));
	}

	// 3. Total stock value (price * stock)
	public double getTotalStockValue(List<Product> list) {
		return list.stream().mapToDouble(p -> p.getPrice() * p.getStock()).sum();
	}

	// 4. Highest sold units
	public Optional<Product> getHighestSoldUnit(List<Product> list) {
		return list.stream().max(Comparator.comparingInt(Product::getSoldUnit));
	}

	// 5. Sort by sold units descending
	public List<Product> getSortedBySoldUnits(List<Product> list) {
		return list.stream().sorted(Comparator.comparingInt(Product::getSoldUnit).reversed())
				.collect(Collectors.toList());
	}

	// 6. Map product name -> stock
	public Map<String, Integer> getNameWithStock(List<Product> list) {
		return list.stream().collect(Collectors.toMap(Product::getName, Product::getStock));
	}

	// 7. Check all products have stock > 0
	public boolean allProductsInStock(List<Product> list) {
		return list.stream().allMatch(p -> p.getStock() > 0);
	}
}

//package com.chandru.Stream_API_Product_Inventory.model;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class ProductService {
//	//1.find out stock prodcuts
//	public List<Product> getStockProduct(List<Product>list){
//		return list.stream().filter(p->p.getStock());
//	}
//	
//	//2.group product by category
//	public Map<String, List<Product>> getGroupByCategory(List<Product>list){
//		return list.stream().collect(Collectors.groupingBy(Product::getCategory));
//	}
//	
//	//3.calculate total stock value (price  * stock)
//	public Map<int,List<Product>> getTotalStockValue (List<Product>list){
//		list.stream().filter(p->p.getPrice()*p.getStock()).map(Product::getPrice).collect(Collectors.toList());
//	}
//	
//	//4.find the product with highest sold unit
//	public Optional<Product> getHighestSoldUnit(List<Product>list){
//		return list.stream().max(Comparator.comparingInt(Product::getSoldUnit));
//	}
//	
//	//5.list the product sorted by sold units descending order
//	public List<Product> getSortedBySoldUnits(List<Product>list){
//		return list.stream().filter(s->s.getSoldUnit()).sorted().reverse();
//	}
//	
//	//6.create a map of product name to stock
//	public Map<String,int> getNameWithStock(List<Product>list){
//		return list.stream().map(Product::getName,Product::getStock).collect(Collector.toList());
//	}
//	
//	//7.check all product stock have the greater than zero
//	public List<Product> getStockWithZero(List<Product>list){
//		return list.stream().filter(s->s.getStock()>0);
//	}
//	
//
//}
