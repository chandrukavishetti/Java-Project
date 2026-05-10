package com.studentcourse.model;

public class Course {
	private int id;
	private String name;
	private int duration;
	private float fees;
	private String trainer;

	// constructor while fetching the data form the database
	public Course(int id, String name, int duration, float fees, String trainer) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.trainer = trainer;
	}

	// constructor for while inserting the course
	public Course(String name, int duration, float fees, String trainer) {
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.trainer = trainer;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public float getFees() {
		return fees;
	}

	public String getTrainer() {
		return trainer;
	}

}
