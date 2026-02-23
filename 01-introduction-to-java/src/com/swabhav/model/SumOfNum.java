package com.swabhav.model;
import java.util.Scanner;

public class SumOfNum {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("enter the number : ");
		int n=input.nextInt();
		if (n<=0) {
			System.out.println("enter the value more than 0");
		}else {
		int sum=0;
		for(int i=1;i<=n;i++) {
			if (i%2==0){
			sum=sum+i;
			}
		}
		System.out.println("the sum of the "+n+" natural number is :  "+sum);
		}
		input.close();
	}

}
