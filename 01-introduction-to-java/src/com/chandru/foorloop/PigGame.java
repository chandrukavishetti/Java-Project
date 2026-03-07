package com.chandru.foorloop;

import java.util.Scanner;
import java.util.Random;

public class PigGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int turn = 0;

        System.out.println("Let's Play PIG!");
        System.out.println("Reach 20 points to win.\n");

        while (totalScore <= 20) {

            turn++;
            int turnScore = 0;
            boolean turnOver = false;

            System.out.println("TURN " + turn);

            while (!turnOver) {

                System.out.print("Roll or hold? (r/h): ");
                char choice = scanner.next().charAt(0);

                if (choice == 'r') {

                    int dice = random.nextInt(6) + 1;
                    System.out.println("Die: " + dice);

                    if (dice == 1) {
                        System.out.println("Turn over. No score.\n");
                        turnScore = 0;
                        turnOver = true;
                    } else {
                        turnScore += dice;
                    }

                } else if (choice == 'h') {

                    totalScore += turnScore;
                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore + "\n");
                    turnOver = true;
                }
            }
        }

        System.out.println("You finished in " + turn + " turns!");
        System.out.println("Game over!");

        scanner.close();
    }
}