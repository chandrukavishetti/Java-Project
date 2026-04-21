package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.GroupedAssertion;

class GroupedAssertionTest {

	GroupedAssertion groupedassertion;

	@BeforeEach
	void setUp() {
		groupedassertion = new GroupedAssertion();
	}

	// Valid case
	@Test
	void shouldValidateUserDetailsWhenInputsAreValid() {

		String name = groupedassertion.userName("chandrashekhar");
		int age = groupedassertion.userAge(22);

		assertAll("Valid User Details", () -> assertEquals("chandrashekhar", name), () -> assertEquals(22, age),
				() -> assertNotNull(name), () -> assertTrue(age > 0));
	}

	// Invalid case - null name & negative age
	@Test
	void shouldValidateUserDetailsWhenInputsAreInvalid() {

		String name = groupedassertion.userName(null);
		int age = groupedassertion.userAge(-10);

		assertAll("Invalid User Details", () -> assertNull(name), () -> assertEquals(-1, age),
				() -> assertTrue(age < 0));
	}

	// empty string
	@Test
	void shouldHandleEmptyUserName() {

		String name = groupedassertion.userName("   ");
		int age = groupedassertion.userAge(0);

		assertAll("Edge Case", () -> assertNull(name), () -> assertEquals(0, age));
	}
}