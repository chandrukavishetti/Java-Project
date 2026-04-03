package com.chandru.Stream_API_Hospital_Patient.model;

public class Patient {
	private int id;
	private String name;
	private int age;
	private String disease;
	private boolean admitted;
	private double amount;

	public Patient(int id, String name, int age, String disease, boolean admitted, double amount) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.disease = disease;
		this.admitted = admitted;
		this.amount = amount;
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

	public boolean getAdmitted() {
		return admitted;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Id : " + id + " name : " + name + " age : " + age + " disease : " + disease + " admitted : " + admitted
				+ " amount : " + amount;
	}

}
