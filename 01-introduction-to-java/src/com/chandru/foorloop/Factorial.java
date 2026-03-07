package com.chandru.foorloop;
import java.util.Scanner;
public class Factorial {
	public static void main(String[]args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the number to get factorial : ");
		int fact=scanner.nextInt();
		int base=1;
		for(int i=1;i<=fact;i++) {
			base=base*i;
		}
		System.out.println("factorial of "+fact+" is = "+base);
		scanner.close();
	}

}
