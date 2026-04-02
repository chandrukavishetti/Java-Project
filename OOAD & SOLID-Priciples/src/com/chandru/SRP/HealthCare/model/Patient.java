package com.chandru.SRP.HealthCare.model;

public class Patient {
	private int id;
	private String name;
	private int age;
	private String disease;
	private int mobileNo;

	public Patient(int id, String name, int age, String disease, int mobileNo) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.disease = disease;
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDisease() {
		return disease;
	}

	public int getMobileNo() {
		return mobileNo;
	}

}
