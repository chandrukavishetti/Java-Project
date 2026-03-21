package com.chandru.practice.model;

import com.chandru.practice.model.Shape;

public class Circle extends Shape {
	private double circleSize;

	public Circle(double size, double circleSize) {
		super(size);
		this.circleSize = circleSize;
	}

	@Override
	public void calculateArea() {
		double result = size * circleSize;
		System.out.println("circle is : " + result);
	}

}
