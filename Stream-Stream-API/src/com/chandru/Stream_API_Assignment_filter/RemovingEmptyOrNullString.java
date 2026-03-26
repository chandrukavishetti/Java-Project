package com.chandru.Stream_API_Assignment_filter;

import java.util.Arrays;
import java.util.List;

public class RemovingEmptyOrNullString {
	public static void main(String[] args) {
		List<String> blankValues = Arrays.asList("", " ", "cmk", "pmk", "hp", "bhart");
		System.out.println("Befor applying the filter");
		blankValues.forEach(System.out::println);

		System.out.println("null and blank values");
		blankValues.stream().filter(blank -> blank == null).forEach(System.out::println);
	}

}
