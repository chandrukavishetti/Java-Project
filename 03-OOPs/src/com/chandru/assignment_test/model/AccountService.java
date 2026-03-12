package com.chandru.assignment_test.model;

public class AccountService {

	private AccountRepository repository;

	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	public void addAccount(Account account) {
		repository.addAccount(account);
	}

	public void displayAccounts() {

		Account[] list = repository.getAllAccounts();

		for (Account acc : list) {

			if (acc != null) {
				acc.displayAccountDetails(); // runtime polymorphism
			}
		}
	}
}