package com.chandru.abstract_interface_exception.model1;

public class LoanValidator {

    public void validate(double amount, double interest) throws InvalidLoanException {
        if (amount <= 0) {
            throw new InvalidLoanException("Loan amount must be positive");
        }
        if (interest <= 0) {
            throw new InvalidLoanException("Interest rate must be positive");
        }
    }

  
    public int loanType(int typeLoan) throws InvalidLoanException {
        if (typeLoan > 3 || typeLoan < 1) {
            throw new InvalidLoanException("Error: Enter a number between 1 and 3 only.");
        }
        return typeLoan; 
    }
}