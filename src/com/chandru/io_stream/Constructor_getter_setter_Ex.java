package com.chandru.io_stream;

class Student {

	private String name;
	private int age;

	// Constructor
	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for age
	public int getAge() {
		return age;
	}

	// Setter for age
	public void setAge(int age) {
		this.age = age;
	}
}

public class Constructor_getter_setter_Ex {
	public static void main(String[] args) {

		Student s1 = new Student("Chandru", 22);

		// Using getter
		System.out.println("Name: " + s1.getName());
		System.out.println("Age: " + s1.getAge());

		// Using setter
		s1.setAge(23);

		System.out.println("Updated Age: " + s1.getAge());
	}
}
