package com.chandru.array;

public class SecondMaxOfArray {
	public static void main(String[] args) {
		int[] array = { 10, 25, 23, 18, 67, 11 };
		if (array.length < 2) {
			System.out.println("Array must have at least 2 element ");
			return;
		}
		int max, secondMax;
		if (array[0] > array[1]) {
			max = array[0];
			secondMax = array[1];
		} else {
			max = array[1];
			secondMax = array[0];
		}
		for (int i = 2; i < array.length; i++) {
			if (array[i] > max) {
				secondMax = max;
				max = array[i];
			} else if (array[i] > secondMax && array[i] != max) {
				secondMax = array[i];
			}
		}
		System.out.println("second largest element in a array is : " + secondMax);
	}

}
