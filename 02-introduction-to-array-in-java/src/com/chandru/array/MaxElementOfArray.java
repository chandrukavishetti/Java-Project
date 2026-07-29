package com.chandru.array;

public class MaxElementOfArray {
	public static void main(String[] args) {
		int[] array = { 10, 15, 21, 43, 50 };
		int max_element = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max_element) {
				max_element = array[i];
			}
		}
		System.out.println("maximum number in the array is : " + max_element);
	}

}
