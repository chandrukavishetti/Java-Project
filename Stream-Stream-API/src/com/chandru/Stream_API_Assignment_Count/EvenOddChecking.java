package com.chandru.Stream_API_Assignment_Count;

import java.util.Arrays;
import java.util.List;

public class EvenOddChecking {
	public static void main(String[] args) {
		List<Integer> evenOdd=Arrays.asList(10,25,67,45,80,13);
		
		long countEven=evenOdd.stream().filter(even->even%2==0).count();
		long countOdd=evenOdd.stream().filter(odd->odd%2!=0).count();
		
		System.out.println("even numbers in the list : "+countEven);
		System.out.println("odd numbers in the list : "+countOdd);
	}

}
