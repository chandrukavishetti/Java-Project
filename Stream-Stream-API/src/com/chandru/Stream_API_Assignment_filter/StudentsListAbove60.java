package com.chandru.Stream_API_Assignment_filter;

import java.util.Arrays;
import java.util.List;

public class StudentsListAbove60 {
	public static void main(String[] args) {
		List<Integer> marks = Arrays.asList(10, 67, 61, 78, 91, 76, 55, 85, 81, 81);

		System.out.println("before appling the filter");
		marks.forEach(System.out::println);

		System.out.println("Student Score more than 60 : ");
		marks.stream().filter(num -> num > 60).forEach(System.out::println);
	}

}
