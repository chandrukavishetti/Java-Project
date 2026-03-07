package com.chandru.exception_Assignement.model;

public class Multiple_catch_block {
	public static void main(String[] args) {
		String[] array = { "monocept", "cognizant", null };
		try {

			System.out.println(array[5]);

		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("it is out of range of the array");
		}

		try {
			System.out.println(array[2].length());
		} catch (NullPointerException ne) {
			System.out.println("length of the string is null");
		} finally {
			System.out.println("finally block");
		}
	}

}
