package com.chandru.abstract_interface_exception.model1;

import java.util.Scanner;

//import com.chandru.abstract_interface_exception.model.Loan;
//import com.chandru.abstract_interface_exception.model.CarLoan;
//import com.chandru.abstract_interface_exception.model.EducationLoan;
//import com.chandru.abstract_interface_exception.model.HomeLoan;
//import com.chandru.abstract_interface_exception.model.InvalidLoanException;
//import com.chandru.abstract_interface_exception.model.LoanEligibility;
//import com.chandru.abstract_interface_exception.model.LoanValidator;
//import com.chandru.abstract_interface_exception.model.SystemConfig;

public class LoanService {

	private Scanner scanner = new Scanner(System.in);
	private LoanValidator validator = new LoanValidator();

	public void startLoanProcessing() {

		Loan[] loans = new Loan[3];

		for (int i = 0; i < loans.length; i++) {

			try {
				loans[i] = createLoanFromUser();
			} catch (InvalidLoanException e) {
				System.out.println(e.getMessage());
				i--;
			}

		}

		processLoans(loans);
	}

	private Loan createLoanFromUser() throws InvalidLoanException {

		int type = getLoanType();

		int id = getLoanId();

		String name = getBorrowerName();

		double amount = getAmount();

		double rate = getInterestRate();

		validator.validate(amount, rate);

		Loan loan = createLoanObject(type, id, name, amount, rate);

		checkEligibility(loan, amount);

		return loan;
	}

	private int getLoanType() {

		System.out.println("Select Loan Type");
		System.out.println("1 Home Loan");
		System.out.println("2 Car Loan");
		System.out.println("3 Education Loan");

		return scanner.nextInt();
	}

	private int getLoanId() {

		System.out.println("Enter Loan ID");

		return scanner.nextInt();
	}

	private String getBorrowerName() {

		System.out.println("Enter Borrower Name");

		return scanner.next();
	}

	private double getAmount() {

		System.out.println("Enter Principal Amount");

		return scanner.nextDouble();
	}

	private double getInterestRate() {

		System.out.println("Enter Interest Rate");

		return scanner.nextDouble();
	}

	private Loan createLoanObject(int type, int id, String name, double amount, double rate) {

		if (type == 1) {
			return new HomeLoan(id, name, amount, rate);
		}

		if (type == 2) {
			return new CarLoan(id, name, amount, rate);
		}

		return new EducationLoan(id, name, amount, rate);
	}

	private void checkEligibility(Loan loan, double amount) {

		LoanEligibility eligibility = (LoanEligibility) loan;

		boolean result = eligibility.checkEligibility(amount);

		if (result) {
			System.out.println("Loan Eligible");
			return;
		}

		System.out.println("Loan Not Eligible");
	}

	private void processLoans(Loan[] loans) {

		for (Loan loan : loans) {

			System.out.println("----------------");

			loan.displayLoan();

			double repayment = loan.calculateRepayment();

			System.out.println("Repayment Amount : " + repayment);
		}
	}
}