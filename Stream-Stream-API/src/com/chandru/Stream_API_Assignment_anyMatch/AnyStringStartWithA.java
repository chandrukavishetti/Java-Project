package com.chandru.Stream_API_Assignment_anyMatch;

import java.util.Arrays;
import java.util.List;

public class AnyStringStartWithA {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "Pruthiviraj", "Megharaj", "Sudha", "ajayPratap");

		boolean result = names.stream().anyMatch(name -> name.toUpperCase().startsWith("A"));

		System.out.println("in the list any name starts with letter 'A' ? : " + result);
	}

}
