package com.chandru.assignment_test.model;

public class AccountRepository {

	private Account[] accounts;
	private int index = 0;

	public AccountRepository(int size) {
		accounts = new Account[size];
	}

	public void addAccount(Account account) {

		if (index < accounts.length) {
			accounts[index++] = account;
		} else {
			System.out.println("Account storage full");
		}
	}

	public Account[] getAllAccounts() {
		return accounts;
	}
}