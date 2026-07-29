package com.chandru.array;
import java.util.Arrays;

public class Array_in_java {
	public static void main(String []args) {
		int[] numbers= {10,20,40,30,15,12};
		/* for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		} */
		for(int num:numbers) {
			System.out.print(num);
		}
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}

}
