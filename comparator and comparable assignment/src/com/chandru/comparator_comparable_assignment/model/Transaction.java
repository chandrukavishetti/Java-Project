package com.chandru.comparator_comparable_assignment.model;

public class Transaction {
	private double amount;
	private int id;

	public Transaction(double amount, int id) {
		this.amount = amount;
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public int getId() {
		return id;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "(" + amount + ")";
	}

}
