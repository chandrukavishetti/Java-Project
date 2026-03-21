package com.chandru.comparator_comparable_assignment.test;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.chandru.comparator_comparable_assignment.model.Transaction;

public class TransactionSorterTest {

    public static class AmountDescIdAsce implements Comparator<Transaction> {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            // 1. Sort Amount: Descending (t2 vs t1)
            int amountComparison = Double.compare(t2.getAmount(), t1.getAmount());

            if (amountComparison != 0) {
                return amountComparison;
            }

            // 2. If amounts are equal, sort ID: Ascending (t1 vs t2)
            // Use Integer.compare for the 'id' field
            return Integer.compare(t1.getId(), t2.getId());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();
        int numberOfTransaction = 0;

        System.out.println("==== Transaction Sorter =====");


        while (true) {
            try {
                System.out.print("How many transactions do you want to enter? ");
                numberOfTransaction = Integer.parseInt(scanner.nextLine());
                if (numberOfTransaction <= 0) {
                    System.out.println("Error: Please enter a positive integer.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number only.");
            }
        }

        for (int i = 0; i < numberOfTransaction; i++) {
            System.out.println("\nTransaction " + (i + 1) + ":");


            double amount = 0;
            while (true) {
                try {
                    System.out.print("Enter transaction amount: ");
                    amount = Double.parseDouble(scanner.nextLine());
                    if (amount <= 0) {
                        System.out.println("Error: Amount must be positive.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a numeric amount.");
                }
            }


            int id = 0;
            while (true) {
                try {
                    System.out.print("Enter transaction ID: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (id <= 0) {
                        System.out.println("Error: ID must be positive.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a numeric ID.");
                }
            }
            transactions.add(new Transaction(amount, id));
        }

        // Apply Sorting
        Collections.sort(transactions, new AmountDescIdAsce());

        // Display Results
        System.out.println("\n--- Sorted Results (Amount Desc, ID Asce) ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        
        scanner.close();
    }
}