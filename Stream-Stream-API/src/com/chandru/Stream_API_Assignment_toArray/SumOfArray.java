package com.chandru.Stream_API_Assignment_toArray;

import java.util.Arrays;

public class SumOfArray {
	public static void main(String[] args) {
		int[] numbers = { 10, 30, 20, 50 };

		int sum = Arrays.stream(numbers).sum();

		System.out.println("tje sum pf arrau  e;ements : " + sum);
	}
}
