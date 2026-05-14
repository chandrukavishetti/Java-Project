package com.chandru.collection.collegestudentmodel3;

import java.util.Map;

public class UnderGraduateStudent extends Student {
	private int semester;

	public UnderGraduateStudent(int studentId,String name,String department,Map<String,Integer>marks,int semester) {
		super(studentId,name,department,Map<String,Integer>);
		this.semester=semester;
	}

	@Override
	public void display() {
		System.out.println("student id : " + getStudentId() + " name : " + getName() + " department " + getDepartment()
				+ " subject wise marks : " + getMarks());
	}

}
