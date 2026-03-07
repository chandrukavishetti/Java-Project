package com.swabhav.model;
import java.util.Scanner;

public class EvenOddChecker {
	public static void main (String[]args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the number : ");
		int number=scanner.nextInt();
		if (number%2==0) {
			System.out.println("user entered number is even");
		
		}else {
			System.out.println("user entered number is odd");
		}
	scanner.close();
	}
}
