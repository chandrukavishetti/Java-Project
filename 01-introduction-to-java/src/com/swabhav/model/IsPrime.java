package com.swabhav.model;
import java.util.Scanner;
public class IsPrime {
	    public static void main(String[] args) {
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        
	        if (number <= 1) {
	            System.out.println("Not Prime number");
	            return;
	        }
	        
	        for (int i = 2; i < number; i++) {
	            if (number % i == 0) {
	                System.out.println("Not Prime number");
	                return;
	            }
	        }
	        
	        System.out.println("Prime number");
	        
	        scanner.close();    
	    }
	    
	}


