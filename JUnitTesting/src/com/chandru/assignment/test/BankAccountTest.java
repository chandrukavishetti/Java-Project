package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.BankAccount;

class BankAccountTest {

	BankAccount bankaccount;

	@BeforeEach
	void setUp() {
		bankaccount = new BankAccount();
	}

	// DEPOSIT

	@Test
	void shouldReturnValidIfDepositAmountIsValid() {
		assertEquals("Valid operation", bankaccount.deposit(100));
	}

	@Test
	void shouldReturnInvalidIfDepositAmountIsNegative() {
		assertEquals("Invalid operation", bankaccount.deposit(-100));
	}

	@Test
	void shouldReturnInvalidIfDepositAmountIsZero() {
		assertEquals("Invalid operation", bankaccount.deposit(0));
	}

	@Test
	void shouldIncreaseBalanceAfterDeposit() {
		bankaccount.deposit(200);
		assertEquals(200, bankaccount.getBalance());
	}

	// WITHDRAW

	@Test
	void shouldReturnInvalidIfWithdrawAmountIsMoreThanBalance() {
		bankaccount.deposit(100);
		assertEquals("Invalid operation", bankaccount.withdraw(200));
	}

	@Test
	void shouldReturnInvalidIfWithdrawAmountIsNegative() {
		assertEquals("Invalid operation", bankaccount.withdraw(-10));
	}

	@Test
	void shouldReturnInvalidIfWithdrawAmountIsZero() {
		assertEquals("Invalid operation", bankaccount.withdraw(0));
	}

	@Test
	void shouldReturnValidIfWithdrawAmountIsCorrect() {
		bankaccount.deposit(200);
		assertEquals("Valid operation", bankaccount.withdraw(100));
	}

	@Test
	void shouldDecreaseBalanceAfterWithdraw() {
		bankaccount.deposit(200);
		bankaccount.withdraw(50);
		assertEquals(150, bankaccount.getBalance());
	}

	// COMBINED

	@Test
	void shouldReturnUpdatedBalanceWhenDepositIsSuccessful() {
		bankaccount.deposit(500);
		bankaccount.withdraw(200);
		bankaccount.deposit(100);

		assertEquals(400, bankaccount.getBalance());
	}
}