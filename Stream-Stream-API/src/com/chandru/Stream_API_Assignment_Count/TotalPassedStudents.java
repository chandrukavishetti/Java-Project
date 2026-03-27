package com.chandru.Stream_API_Assignment_Count;

import java.util.Arrays;
import java.util.List;

public class TotalPassedStudents {
	public static void main(String[] args) {
		List<Integer> marks = Arrays.asList(10, 40, 37, 98, 76, 85, 33);

		long passedStudent = marks.stream().filter(num -> num > 35).count();

		System.out.println(passedStudent);

	}

}
