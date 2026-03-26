package com.chandru.Assignment_Function;

import java.util.Scanner;
import java.util.function.Function;

public class StringLengthCalculater {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Function<String, Integer> nameLength = str -> str.length();
		System.out.println("enter the 3 names to get the length of each ");
		for (int i = 0; i < 3; i++) {
			System.out.print("enter the " + i + "  name : ");
			String name = scanner.nextLine();

			int length = nameLength.apply(name);

			System.out.println("Length of the name : " + name + "is : " + length);
		}
		scanner.close();
	}

}
