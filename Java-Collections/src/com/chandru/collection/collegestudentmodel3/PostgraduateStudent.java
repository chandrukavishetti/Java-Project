package com.chandru.collection.collegestudentmodel3;

import java.util.Map;

public class PostgraduateStudent extends Student {
	private String specialization;

	public PostgraduateStudent(int studentId,String name,String department,Map<String,Integer>marks,String specialization) {
		super(studentId,name,department,Map<String,Integer>());
		this.specialization=specialization;
	}

	@Override
	public void display() {
		System.out.println("student id : " + getStudentId() + " name : " + getName() + " department " + getDepartment()
				+ " subject wise marks : " + getMarks());
	}

}
