package com.chandru.Stream_API_Assignment_toArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CovertingListUsingStream {
	public static void main(String[] args) {
		String[] names = { "chandrashekhar", "miechecal", "jacob", "chirs", "deviliers" };

		List<String> tolist = Arrays.stream(names).collect(Collectors.toList());

		System.out.println("covered list : ");

		tolist.forEach(System.out::println);
	}

}
