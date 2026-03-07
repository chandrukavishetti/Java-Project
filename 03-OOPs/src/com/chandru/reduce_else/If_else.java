package com.chandru.reduce_else;
import java.util.Scanner;
public class If_else {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the the to check even or odd : ");
		int number=scanner.nextInt();
		if(number%2==0) {
			System.out.println("You entered number is Even");
		}else {
			System.out.println("you entered number is Odd");
		}
		scanner.close();
	}

}
