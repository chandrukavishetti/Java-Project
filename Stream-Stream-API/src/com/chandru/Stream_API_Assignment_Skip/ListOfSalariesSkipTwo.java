package com.chandru.Stream_API_Assignment_Skip;

import java.util.Arrays;
import java.util.List;

public class ListOfSalariesSkipTwo {
	public static void main(String[] args) {
		List<Integer> salaries = Arrays.asList(20000, 25000, 110000, 350000, 31000);

		salaries.stream().sorted().skip(2).forEach(System.out::println);
	}

}
