package com.chandru.Stream_API_Assignment_Sorted;

import java.util.Arrays;
import java.util.List;

public class SortingByLength {
	public static void main(String[] args) {
		List<String> sort = Arrays.asList("RoyalEnfield", "GT650", "KTM", "Pulsure", "Ather");

		sort.stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);

	}

}
