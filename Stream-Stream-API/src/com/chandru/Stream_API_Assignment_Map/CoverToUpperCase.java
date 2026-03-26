package com.chandru.Stream_API_Assignment_Map;

import java.util.Arrays;
import java.util.List;

public class CoverToUpperCase {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "pruthviraj", "megharaj", "sudha", "monocept");

		names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
	}

}
