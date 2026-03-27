package com.chandru.Stream_API_Assignment_Count;

import java.util.Arrays;
import java.util.List;

public class Product20PercentDiscount {
	public static void main(String[] args) {
		List<Integer> price = Arrays.asList(3000, 250, 580, 600, 400);

		long result = price.stream().filter(amt -> (amt * 0.8) > 500).count();

		System.out.println("total price 20% discounted and above 500 : " + result);
	}

}
