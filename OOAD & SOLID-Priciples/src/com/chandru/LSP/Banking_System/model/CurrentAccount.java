package com.chandru.LSP.Banking_System.model;

public class CurrentAccount extends Account implements Withdrawable {

    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(" Withdrawn: " + amount);
    }
}