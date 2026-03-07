package com.chandru.wrapper;

public class TypeCasting {
	public static void main(String[] args) {
		int myInt = 9;
		double myDouble = myInt; // Auto casting
		System.out.println(myInt); // Output: 9
		System.out.println(myDouble); // Output: 9.0

		double myDouble1 = 9.78d;
		int myInt1 = (int) myDouble1; // Manual casting: double to int
		System.out.println(myDouble1); // Output: 9.78
		System.out.println(myInt1); // Output: 9 (decimal part is truncated)

	}

}
