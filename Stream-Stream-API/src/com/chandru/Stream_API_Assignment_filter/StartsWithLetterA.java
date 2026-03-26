package com.chandru.Stream_API_Assignment_filter;

import java.util.Arrays;
import java.util.List;

public class StartsWithLetterA {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "akash", "ajayPratap", "abhaypratap", "shankar");

//		System.out.println("before aplying the filter : " + names); //not works gives the memory address
		System.out.println("before applying ");
		names.forEach(System.out::println);

		System.out.println("\nafter applying the filter");
		names.stream().filter(name -> name.toLowerCase().startsWith("a")).forEach(System.out::println);
	}

}
