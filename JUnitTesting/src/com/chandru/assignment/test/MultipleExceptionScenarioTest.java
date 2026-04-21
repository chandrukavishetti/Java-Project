package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.InvalidAmountException;
import com.chandru.assignment.code.InsufficientFundBalanceException;
import com.chandru.assignment.code.MultipleExceptionScenario;

class MultipleExceptionScenarioTest {

	MultipleExceptionScenario multiplescenario;

	@BeforeEach
	void setUp() {
		multiplescenario = new MultipleExceptionScenario();
		multiplescenario.balance = 100; // initial balance
	}

	@Test
	void shouldThrowInsufficientFundExceptionWhenAmountGreaterThanBalance() {

		InsufficientFundBalanceException ex = assertThrows(InsufficientFundBalanceException.class,
				() -> multiplescenario.withdraw(200));

		assertEquals("Insufficient balance", ex.getMessage());
	}

	@Test
	void shouldThrowInvalidAmountExceptionWhenAmountIsNegative() {

		InvalidAmountException ex = assertThrows(InvalidAmountException.class, () -> multiplescenario.withdraw(-10));

		assertEquals("Amount must be greater than zero", ex.getMessage());
	}

	@Test
	void shouldThrowInvalidAmountExceptionWhenAmountIsZero() {

		assertThrows(InvalidAmountException.class, () -> multiplescenario.withdraw(0));
	}

	@Test
	void shouldWithdrawSuccessfullyWhenAmountIsValid() throws Exception {

		double remaining = multiplescenario.withdraw(50);

		assertEquals(50, remaining);
	}
}