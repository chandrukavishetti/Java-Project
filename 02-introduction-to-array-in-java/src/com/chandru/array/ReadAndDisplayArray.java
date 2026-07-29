package com.chandru.array;

import java.util.Scanner;

public class ReadAndDisplayArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the size of the array : ");
		int size = scanner.nextInt();
		if (size > 0) {
			System.out.println("now enter the "+size+" element followed by pressing enter key : ");
			int[] num = new int[size];
			for (int i = 0; i < size; i++) {
				num[i] = scanner.nextInt();
			}
			for (int i = 0; i < size; i++) {
				System.out.println(num[i]);
			}
		} else {
			System.out.println("enter the size of array in positive : ");
		}
		scanner.close();
	}

}
