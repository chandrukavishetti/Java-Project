package com.chandru.practice.test;

import com.chandru.practice.model.Square;

public class ShapeTest {
	public static void main(String[] args) {
		// 1. Create a Square with initial side of 10
		Square mySquare = new Square(10.0);

		// 2. Initial draw
		mySquare.draw();

		// 3. Resize by a factor of 2.0 (should become 20.0)
		mySquare.resize(2.0);

		// 4. Draw again to see the update
		mySquare.draw();

		// 5. Shrink it by 0.5 (should become 10.0 again)
		mySquare.resize(0.5);
		mySquare.draw();
	}
}