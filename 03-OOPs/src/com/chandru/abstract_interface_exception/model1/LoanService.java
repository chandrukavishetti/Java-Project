package com.chandru.abstract_interface_exception.model1;

import java.util.Scanner;

public class LoanService {

	private Scanner scanner = new Scanner(System.in);
	private LoanValidator validator = new LoanValidator();

	private Loan[] loans = new Loan[100];
	private int currentLoanCount = 0;

	public void startLoanProcessing() {
		boolean running = true;

		while (running) {
			System.out.println("\n--- Loan Management System ---");
			System.out.println("1. Register Loans");
			System.out.println("2. Display All Recorded Loans");
			System.out.println("3. Exit");
			System.out.print("Select an option: ");

			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				int size = getArraySize();

				if (currentLoanCount + size > loans.length) {
					System.out.println("Error: Not enough storage. You can only add "
							+ (loans.length - currentLoanCount) + " more loans.");
					break;
				}

				for (int i = 0; i < size; i++) {
					try {
						System.out.println("\n--- Processing Loan #" + (currentLoanCount + 1) + " ---");
						loans[currentLoanCount] = createLoanFromUser();
						currentLoanCount++;
					} catch (InvalidLoanException e) {
						System.out.println("Error: " + e.getMessage());
						i--; // Repeat the input for this specific loan
					}
				}
				break;

			case "2":
				if (currentLoanCount == 0) {
					System.out.println("No loans are recorded.");
				} else {
					processLoans();
				}
				break;

			case "3":
				System.out.println("Exiting system...");
				running = false;
				break;

			default:
				System.out.println("Invalid selection. Please try again.");
			}
		}
	}

	private int getArraySize() {
		while (true) {
			try {
				System.out.println("How many loans do you want to process in this session?");
				String input = scanner.nextLine();
				int size = Integer.parseInt(input);

				if (size <= 0) {
					System.out.println("Error: Please enter a number greater than 0.");
					continue;
				}
				return size;
			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid input. Please enter a whole number.");
			}
		}
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

	private int getLoanType() throws InvalidLoanException {
		while (true) {
			try {
				System.out.println("Select Loan Type\n1 Home Loan\n2 Car Loan\n3 Education Loan");
				int type = Integer.parseInt(scanner.nextLine());
				return validator.loanType(type);
			} catch (NumberFormatException e) {
				System.out.println("Error: Enter a valid number (1-3)");
			}
		}
	}

	private int getLoanId() throws InvalidLoanException {
		while (true) {
			try {
				System.out.println("Enter Loan ID");
				int id = Integer.parseInt(scanner.nextLine());
				if (id <= 0)
					throw new InvalidLoanException("ID must be positive");
				return id;
			} catch (NumberFormatException e) {
				System.out.println("Error: Enter a numeric ID");
			}
		}
	}

	private String getBorrowerName() throws InvalidLoanException {
		while (true) {
			System.out.println("Enter Borrower Name");
			String name = scanner.nextLine().trim();
			if (name.isEmpty() || !name.matches("[a-zA-Z\\s]+")) {
				System.out.println("Error: Name must contain only letters");
				continue;
			}
			return name;
		}
	}

	private double getAmount() {
		while (true) {
			try {
				System.out.println("Enter Principal Amount");
				double amount = Double.parseDouble(scanner.nextLine());
				if (amount <= 0) {
					System.out.println("Error: Amount must be greater than zero");
					continue;
				}
				return amount;
			} catch (NumberFormatException e) {
				System.out.println("Error: Enter a valid numeric amount");
			}
		}
	}

	private double getInterestRate() {
		while (true) {
			try {
				System.out.println("Enter Interest Rate");
				double rate = Double.parseDouble(scanner.nextLine());
				if (rate <= 0) {
					System.out.println("Error: Interest rate must be greater than zero");
					continue;
				}
				return rate;
			} catch (NumberFormatException e) {
				System.out.println("Error: Enter a valid numeric rate");
			}
		}
	}

	private Loan createLoanObject(int type, int id, String name, double amount, double rate) {
		if (type == 1)
			return new HomeLoan(id, name, amount, rate);
		if (type == 2)
			return new CarLoan(id, name, amount, rate);
		return new EducationLoan(id, name, amount, rate);
	}

	private void checkEligibility(Loan loan, double amount) {
		LoanEligibility eligibility = (LoanEligibility) loan;
		if (eligibility.checkEligibility(amount)) {
			System.out.println("Loan Eligible");
		} else {
			System.out.println("Loan Not Eligible");
		}
	}

	private void processLoans() {
		System.out.println("\n--- All Recorded Loans ---");

		for (int i = 0; i < currentLoanCount; i++) {
			System.out.println("----------------");
			loans[i].displayLoan();
			System.out.println("Repayment Amount : " + loans[i].calculateRepayment());
		}
	}
}