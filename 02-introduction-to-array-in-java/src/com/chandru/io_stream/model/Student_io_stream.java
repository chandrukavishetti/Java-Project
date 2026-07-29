package com.chandru.io_stream.model;

public class Student_io_stream {

	private int id;
	private String name;
	private int marks;

	public Student_io_stream(int id, String name, int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}

	public String toString() {
		return id + "," + name + "," + marks;
	}
}