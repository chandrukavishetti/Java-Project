package com.swabhav.model;

public class Fact1to10 {
	public static void main(String[]argas) {
		int f=1,i=1;
		while(i<=10) {
			f=f*i;
			System.out.println(i+" ! = "+f);
			++i;
		}
	}

}
