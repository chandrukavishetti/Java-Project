package com.swabhav.model;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a 3-digit number: ");
        int num = scanner.nextInt();
        
       
        if (num < 100 || num > 999) {
            System.out.println("Please enter a valid 3-digit number!");
        } else {
            int original = num;
            int sum = 0;
            

            while (num > 0) {
                int digit = num % 10;        
                sum = sum + (digit * digit * digit);  
                num = num / 10;              
            }
            
            
            if (sum == original) {
                System.out.println(original + " is an ARMSTRONG number");
            } else {
                System.out.println(original + " is NOT an Armstrong number");
            }
        }
        
        scanner.close();
    }
}