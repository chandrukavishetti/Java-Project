package com.chandru.Stream_API_Student_Result.model;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

	// 1. Passed Students
	public List<Student> getPassedStudents(List<Student> list, double passMarks) {
		return list.stream().filter(s -> s.getMarks() >= passMarks).collect(Collectors.toList());
	}

	// 2. Top 3 Students
	public List<Student> getTop3Students(List<Student> list) {
		return list.stream().sorted(Comparator.comparing(Student::getMarks).reversed()).limit(3)
				.collect(Collectors.toList());
	}

	// 3. Group by Section
	public Map<String, List<Student>> groupBySection(List<Student> list) {
		return list.stream().collect(Collectors.groupingBy(Student::getSection));
	}

	// 4. Count Section-wise
	public Map<String, Long> countBySection(List<Student> list) {
		return list.stream().collect(Collectors.groupingBy(Student::getSection, Collectors.counting()));
	}

	// 5. Average Marks by Section
	public Map<String, Double> avgMarksBySection(List<Student> list) {
		return list.stream()
				.collect(Collectors.groupingBy(Student::getSection, Collectors.averagingDouble(Student::getMarks)));
	}

	// 6. Names in Uppercase
	public List<String> getNamesUpperCase(List<Student> list) {
		return list.stream().map(s -> s.getName().toUpperCase()).collect(Collectors.toList());
	}

	// 7. Any Full Marks
	public boolean hasFullMarks(List<Student> list, double fullMarks) {
		return list.stream().anyMatch(s -> s.getMarks() == fullMarks);
	}
}