package com.aziz.unittest.simpleCalculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aziz.unittest.model.DataService;
import com.aziz.unittest.service.SimpleCalculation;

class SimpleCalculationMockTest {
	
	SimpleCalculation simpleCalculation = new SimpleCalculation();
	DataService dataService = mock(DataService.class);
	
	@BeforeEach
	public void before() {
		simpleCalculation.setCalculateEntity(dataService);
	}

	@Test
	void calculateSumUseMockService_multipleValue() {
		when(dataService.getAllData()).thenReturn(new int[] {2,3,2});
		assertEquals(7, simpleCalculation.calculateSumUseEntity());
	}
	
	@Test
	void calculateSumUseMockService_empty() {
		when(dataService.getAllData()).thenReturn(new int[] {});
		assertEquals(0, simpleCalculation.calculateSumUseEntity());
	}
	
	@Test
	void calculateSumUseMockService_oneValue() {
		when(dataService.getAllData()).thenReturn(new int[] {5});
		assertEquals(5, simpleCalculation.calculateSumUseEntity());
	}
	
}
