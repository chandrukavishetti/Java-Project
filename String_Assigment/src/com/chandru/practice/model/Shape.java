package com.chandru.practice.model;

public abstract class Shape {
	protected double size;
	public Shape(double size) {
		this.size=size;
	}
	public double getsize() {
		return size;
	}
	protected abstract void calculateArea();

}
