package com.chandru.abstract_interface_exception.model1;

public abstract class Loan {

	protected int loanId;
	protected String borrowerName;
	protected double principal;
	protected double interestRate;

	public Loan(int loanId, String borrowerName, double principal, double interestRate) {

		System.out.println("Loan constructor called");

		this.loanId = loanId;
		this.borrowerName = borrowerName;
		this.principal = principal;
		this.interestRate = interestRate;
	}

	public abstract double calculateRepayment();

	public void displayLoan() {
		System.out.println("Loan ID: " + loanId);
		System.out.println("Borrower: " + borrowerName);
		System.out.println("Principal: " + principal);
		System.out.println("Interest Rate: " + interestRate);
	}
}