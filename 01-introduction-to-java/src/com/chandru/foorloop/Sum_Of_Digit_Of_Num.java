package com.chandru.foorloop;
import java.util.Scanner;
public class Sum_Of_Digit_Of_Num {
	public static void main(String[]args) {
		int sum=0;
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the number : ");
		int num=scanner.nextInt();
		for(int i=num;num!=0;num/=10) {
			 sum += i%10;
		}
		System.out.println("sum of digit of the number  is   = "+sum);
		scanner.close();
	}

}
