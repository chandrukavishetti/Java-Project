package com.chandru.abstract_interface_exception.model1;

public class EducationLoan extends Loan implements LoanEligibility {

	public EducationLoan(int loanId, String borrowerName, double principal, double interestRate) {
		super(loanId, borrowerName, principal, interestRate);
		System.out.println("EducationLoan constructor called");
	}

	@Override
	public double calculateRepayment() {
		return principal + (principal * interestRate * 3 / 100);
	}

	@Override
	public boolean checkEligibility(double amount) {

		if (amount <= 2000000) {
			return true;
		}

		return false;
	}
}