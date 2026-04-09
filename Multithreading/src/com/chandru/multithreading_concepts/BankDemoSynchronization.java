package com.chandru.multithreading_concepts;

class BankAccount {
	private int balance = 1000;

	public synchronized void withdraw(int amount) {
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
			balance -= amount;
			System.out.println("your current balance is : " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " insufficient balance : " + balance);
		}
	}

	public void deposit(int amount) {
		System.out.println("processing deposit");

		synchronized (this) {// looks only critical section
			balance += amount;
			System.out.println("deposited balance : " + balance);
		}
	}
}

public class BankDemoSynchronization {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		Runnable withdrawTask = () -> account.withdraw(700);

		Thread person1 = new Thread(withdrawTask, "Arun");
		Thread person2 = new Thread(withdrawTask, "bala");

		person1.start();
		person2.start();

	}
}
//output
//Arun withdrawing 700
//your current balance is : 300
//bala insufficient balance : 300
//
//here the above arun withdraw 700 and balace is 300 and then bala want to withdraw but it
//shows the insufficient balace then it is good