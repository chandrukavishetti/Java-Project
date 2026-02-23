package com.swabhav.model;
import java.util.Scanner;
public class Circle {
	public static void main(String[]args) {
		Scanner ip=new Scanner(System.in);
		double r,area,circum;
		System.out.print("enter the radius of the circle : ");
		r=ip.nextDouble();
		area=Math.PI*r*r;
		circum=2*Math.PI*r;
		System.out.println("area of circle is = "+area);
		System.out.println("circumference of the circle is = "+circum);
		ip.close();
	}

}
