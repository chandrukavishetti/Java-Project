package com.chandru.practice.test;

import com.chandru.practice.model.Circle;
import com.chandru.practice.model.Rectangle;

public class ShapeTest {
	public static void main(String[] args) {
		Circle circle = new Circle(50, 25);
		circle.calculateArea();

		Rectangle rectangle = new Rectangle(20, 30);
		rectangle.calculateArea();

	}

}
