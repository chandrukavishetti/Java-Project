package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chandru.assignment.code.StringUtility;

class StringUtilityTest {

	StringUtility util;

	@BeforeEach
	void setUp() {
		util = new StringUtility();
	}

	// isEmpty

	@Test
	void shouldReturnTrueWhenStringIsNull() {
		assertTrue(util.isEmpty(null));
	}

	@Test
	void shouldReturnTrueWhenStringIsEmpty() {
		assertTrue(util.isEmpty(""));
	}

	@Test
	void shouldReturnTrueWhenStringIsWhitespace() {
		assertTrue(util.isEmpty("   "));
	}

	@Test
	void shouldReturnFalseWhenStringIsNotEmpty() {
		assertFalse(util.isEmpty("hello"));
	}

	// toUpperCase

	@Test
	void shouldReturnNullWhenInputIsAlsoNull() {
		assertNull(util.toUpperCase(null));
	}

	@Test
	void shouldConvertLowercaseToUppercase() {
		assertEquals("HELLO", util.toUpperCase("hello"));
	}

	@Test
	void shouldHandleAlreadyUppercase() {
		assertEquals("HELLO", util.toUpperCase("HELLO"));
	}

	@Test
	void shouldHandleMixedCase() {
		assertEquals("HELLO WORLD", util.toUpperCase("HeLLo WoRLd"));
	}

	// getLength

	@Test
	void shouldReturnNullWhenInputIsNull() {
		assertNull(util.getLength(null));
	}

	@Test
	void shouldReturnZeroForEmptyString() {
		assertEquals(0, util.getLength(""));
	}

	@Test
	void shouldReturnCorrectLength() {
		assertEquals(5, util.getLength("hello"));
	}

	@Test
	void shouldCountWhitespaceCharacters() {
		assertEquals(3, util.getLength("   "));
	}
}