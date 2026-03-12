package com.chandru.abstract_interface_exception.model1;

public class CarLoan extends Loan implements LoanEligibility {

	public CarLoan(int loanId, String borrowerName, double principal, double interestRate) {
		super(loanId, borrowerName, principal, interestRate);
		System.out.println("CarLoan constructor called");
	}

	@Override
	public double calculateRepayment() {
		return principal + (principal * interestRate * 5 / 100);
	}

	@Override
	public boolean checkEligibility(double amount) {

		if (amount <= 1000000) {
			return true;
		}

		return false;
	}
}