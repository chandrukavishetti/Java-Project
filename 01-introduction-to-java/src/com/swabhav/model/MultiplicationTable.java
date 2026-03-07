package com.swabhav.model;
import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner m=new Scanner(System.in);
		System.out.print("enter the number : ");
		int n=m.nextInt();
		for(int i=1;i<=10;i++) {
			System.out.println(+n+"X"+i+"="+n*i);
		}
	m.close();
	}
	

}
