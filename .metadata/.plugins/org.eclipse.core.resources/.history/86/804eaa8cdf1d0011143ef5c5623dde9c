package com.chandru.foorloop;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class RandomNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
		int i = 1;
		System.out.println("you hava only 5 chance to guess");

		while (i <= 5) {
			System.out.print("Enter the number: ");
			int userInput = scanner.nextInt();

			if (userInput == randomNum) {
				System.out.println("You guessed the number correctly! Congrats ");
				break; 
			} else if (userInput < randomNum) {
				System.out.println("Too small number");
			} else {
				System.out.println("Too big number");
			}

			i++; 
		}

		System.out.println("The random number was: " + randomNum);

		scanner.close();
	}
}
