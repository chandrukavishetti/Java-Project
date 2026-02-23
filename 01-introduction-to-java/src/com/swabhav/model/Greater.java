package com.swabhav.model;
import java.util.Scanner;

public class Greater {
	public static void main(String[]args) {
		Scanner a=new Scanner(System.in);
		System.out.print("enter the value of x = ");
		int x=a.nextInt();
		Scanner b=new Scanner(System.in);
		System.out.print("enter the value of y = ");
		int y=b.nextInt();
	
		System.out.println("X = "+x);
		System.out.println("Y = "+y);
		if (x>y) {
			System.out.println("x is grater");
		}else if(x==y){
			System.out.println("both are equal");
		}else {
			System.out.println("y is greater ");
		}
		a.close();
		b.close();
	}
	

}
