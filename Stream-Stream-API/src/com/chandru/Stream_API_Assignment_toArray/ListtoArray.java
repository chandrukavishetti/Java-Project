package com.chandru.Stream_API_Assignment_toArray;

import java.util.Arrays;
import java.util.List;

public class ListtoArray {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Royal", "challengers", "Bengaluru", "Manchester", "City", "United");

		String[] array = names.stream().toArray(String[]::new);

		System.out.println("array elements are : ");

		for (String string : array) {
			System.out.println(string);
		}
	}

}
