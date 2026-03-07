package com.chandru.inheritance.model;

public class SavingsAccount extends Account {

    private double minBalance;

    public SavingsAccount(String accountNumber, String holderName,
                          double balance, double minBalance) {
        super(accountNumber, holderName, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (balance - amount < minBalance) {
            System.out.println("Cannot withdraw. Minimum balance must be maintained.");
            return;
        }

        super.withdraw(amount);
    }
}
