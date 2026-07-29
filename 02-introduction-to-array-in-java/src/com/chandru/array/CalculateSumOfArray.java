package com.chandru.array;

public class CalculateSumOfArray {
	public static void main(String[] args) {
		int[] array= {10,20,30,12,15};
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
		System.out.print("length of the array is : "+sum);
	}

}
