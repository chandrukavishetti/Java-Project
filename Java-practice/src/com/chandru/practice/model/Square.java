package com.chandru.practice.model;

import com.chandru.practice.model.Drawable;
import com.chandru.practice.model.Resizable;

public class Square implements Drawable, Resizable {

	private double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public void resize(double factor) {
		this.side *= factor;
		System.out.println("resizing by factor : " + factor);
	}

	@Override
	public void draw() {
		System.out.println("drawing square with side length : " + side);
	}

	public static void main(String[] args) {
		Square mySquare = new Square(10.0);

		mySquare.draw();

		mySquare.resize(2.0);

		mySquare.draw();
	}

}
