package com.chandru.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized.Parameter;

import com.chandru.assignment.code.MarksValidator;

class MarksValidatorTest {
	MarksValidator marksvalidator;

	@ParameterizedTest
	@CsvSource({ "0,true", "1,true", "99,true", "100,true", "-1,false", "101,false" })

	@BeforeEach
	void setUp() {
		marksvalidator = new MarksValidator();
	}

	void shouldReturnValidOutputForValidInput(int a, boolean expected) {
		assertEquals(expected, marksvalidator.isValidMarks(a));
	}

}
