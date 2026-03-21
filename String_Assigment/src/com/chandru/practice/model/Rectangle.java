package com.chandru.practice.model;

import com.chandru.practice.model.Shape;

public class Rectangle extends Shape {
	private double rectangleSize;

	public Rectangle(double size, double rectangleSize) {
		super(size);
		this.rectangleSize = rectangleSize;
	}

	@Override
	public void calculateArea() {
		double result = size * rectangleSize;
		System.out.println("rectangle :" + result);
	}

}
