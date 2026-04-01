package com.chandru.LSP.Banking_System.model;

public abstract class Account {

    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(" Deposited: " + amount);
    }

    public double getBalance() {
        return balance;
    }
}