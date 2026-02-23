package com.swabhav.model;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner f=new Scanner(System.in);
		System.out.print("enter the number : ");
		int n=f.nextInt();
		int fact=1;
		if(n<=0) {
			System.out.println("enter the more than 0 ");
		}else {
			
			for(int i=1;i<=n;i++) {
				fact=fact*i;
				
			}
		}
		System.out.println("factorial of "+n+" is "+fact);
		f.close();
	}

}
