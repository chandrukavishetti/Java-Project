package com.chandru.Stream_API_Assignment_anyMatch;

import java.util.Arrays;
import java.util.List;

public class AnyStudentFailedLessThan40 {
	public static void main(String[] args) {
		List<Integer> marks = Arrays.asList(45, 89, 78, 98, 55, 49, 39);

		boolean result = marks.stream().anyMatch(number -> number < 40);

		System.out.println("In the list of students any student filed (Less than 40) ? : " + result);
	}

}
