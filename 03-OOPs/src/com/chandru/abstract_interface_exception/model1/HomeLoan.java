package com.chandru.abstract_interface_exception.model1;

public class HomeLoan extends Loan implements LoanEligibility {

	public HomeLoan(int loanId, String borrowerName, double principal, double interestRate) {
		super(loanId, borrowerName, principal, interestRate);
		System.out.println("HomeLoan constructor called");
	}

	@Override
	public double calculateRepayment() {
		return principal + (principal * interestRate * 10 / 100);
	}

	@Override
	public boolean checkEligibility(double amount) {

		if (amount <= 5000000) {
			return true;
		}

		return false;
	}
}