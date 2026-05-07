package com.studentcourse.model;

public class Student {

	private int id;
	private String name;
	private String email;
	private String phone;
	private int age;
	private String city;

	// Constructor used while fetching data from database
	public Student(int id, String name, String email, String phone, int age, String city) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.city = city;
	}

	// Constructor used while inserting new student
	public Student(String name, String email, String phone, int age, String city) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}
}