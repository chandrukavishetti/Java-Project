package com.chandru.Stream_API_Assignment_findFirst;

import java.util.Arrays;
import java.util.List;

public class ListFirstNameFInd {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("chandrashekhar", "kartik", "jacob", "Romario", "Rajat");

		System.out.println(names.stream().findFirst().orElse("no data"));
	}

}
