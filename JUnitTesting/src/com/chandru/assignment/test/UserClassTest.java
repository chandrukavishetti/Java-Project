package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.UserClass;

class UserClassTest {

	UserClass userclass;

	@BeforeEach
	void setUp() {
		userclass = new UserClass();
		System.out.println("Setup: Object Created");
	}

	@AfterEach
	void tearDown() {
		userclass = null;
		System.out.println("Teardown: Object Destroyed");
	}

	// Null name
	@Test
	void shouldReturnNullIfUserNameIsNull() {
		assertNull(userclass.validUser(null));
	}

	// Empty name
	@Test
	void shouldReturnNullIfUserNameIsEmpty() {
		assertNull(userclass.validUser(""));
	}

	// Valid name
	@Test
	void shouldReturnNameIfUserNameIsValid() {
		assertEquals("chandrashekhar", userclass.validUser("chandrashekhar"));
	}

	// Invalid age
	@Test
	void shouldReturnInvalidIfAgeIsNegative() {
		assertEquals("invalid", userclass.validAge(-100));
	}

	// Age > 100
	@Test
	void shouldReturnInvalidIfAgeGreaterThan100() {
		assertEquals("invalid", userclass.validAge(150));
	}

	// Valid age
	@Test
	void shouldReturnValidIfAgeIsCorrect() {
		assertEquals("valid", userclass.validAge(25));
	}
}