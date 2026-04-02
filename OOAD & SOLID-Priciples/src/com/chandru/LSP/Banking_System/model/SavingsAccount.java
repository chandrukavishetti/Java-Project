package com.chandru.LSP.Banking_System.model;

public class SavingsAccount extends Account implements Withdrawable {

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(" Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println(" Withdrawn: " + amount);
        }
    }
}