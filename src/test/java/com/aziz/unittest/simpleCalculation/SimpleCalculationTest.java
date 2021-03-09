package com.aziz.unittest.simpleCalculation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.aziz.unittest.service.SimpleCalculation;

class SimpleCalculationTest {

	@Test
	void sumCalculation_multipleValue() {
		SimpleCalculation simpleCalculation = new SimpleCalculation();
		int result = simpleCalculation.calculateSum(new int[] {2,3,2});
		int expectedResult = 7;
		assertEquals(expectedResult, result);
	}
	
	@Test
	void sumCalculation_empty() {
		SimpleCalculation simpleCalculation = new SimpleCalculation();
		int result = simpleCalculation.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, result);
	}
	
	@Test
	void sumCalculation_oneValue() {
		SimpleCalculation simpleCalculation = new SimpleCalculation();
		int result = simpleCalculation.calculateSum(new int[] {2});
		int expectedResult = 2;
		assertEquals(expectedResult, result);
	}

}
