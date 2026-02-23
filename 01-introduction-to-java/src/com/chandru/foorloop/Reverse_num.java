package com.chandru.foorloop;
import java.util.Scanner;
public class Reverse_num {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter the number : ");
		int num=scanner.nextInt();
		int reverseNum=0;
		for(;num!=0;num/=10) {
			int digit=num%10;
			reverseNum=reverseNum*10+digit;
		}
		System.out.println("Reversed number is : "+reverseNum);
		scanner.close();
	}
	

}
