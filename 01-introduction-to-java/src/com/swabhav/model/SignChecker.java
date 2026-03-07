package com.swabhav.model;
import java.util.Scanner;

public class SignChecker {
	public static void main (String[]args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the number : ");
		int number=scanner.nextInt();
		if (number>0) {
			System.out.println("user entered number is positive");
		}else if (number<0) {
			System.out.println("user entered number is negative");
		}else {
			System.out.println("user entered number is zero");
		}
	scanner.close();
	}
}
