package com.chandru.exception_handiling;

public class Throw_example {
	static void checkAge(int age) {
		if (age < 18) {
			throw new ArithmeticException("age must be above 18");
		}
	}

	public static void main(String[] args) {
		checkAge(16);
	}

}
