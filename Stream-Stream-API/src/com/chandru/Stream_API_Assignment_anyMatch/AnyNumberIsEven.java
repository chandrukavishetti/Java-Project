package com.chandru.Stream_API_Assignment_anyMatch;

import java.util.Arrays;
import java.util.List;

public class AnyNumberIsEven {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(33, 15, 17, 89, 9, 13, 26);

		boolean result = numbers.stream().anyMatch(num -> num % 2 == 0);

		System.out.println("is there any even number in the list : " + result);
	}

}
