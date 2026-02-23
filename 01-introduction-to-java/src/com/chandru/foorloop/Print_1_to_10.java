package com.chandru.foorloop;
import java.util.Scanner;
public class Print_1_to_10 {
	public static void main(String[]args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the number to print : ");
		int num=scanner.nextInt();
		for(int i=1;i<=num;i++) {
			System.out.println(i);
		}
		scanner.close();
	}

}
