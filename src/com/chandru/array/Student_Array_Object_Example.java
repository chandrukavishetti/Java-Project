package com.chandru.array;

public class Student_Array_Object_Example {

	
	static class Student {
		String name;
		int age;

		Student(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void display() {
			System.out.println("Name: " + name + ", Age: " + age);
		}
	}

	public static void main(String[] args) {

		Student[] students = { new Student("Alice", 20), new Student("Bob", 21), new Student("Charlie", 22) };

		for (Student student : students) {
			student.display();
		}
	}
}
