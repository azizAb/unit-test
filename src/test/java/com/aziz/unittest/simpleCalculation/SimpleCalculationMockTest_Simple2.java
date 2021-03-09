package com.aziz.unittest.simpleCalculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aziz.unittest.model.DataService;
import com.aziz.unittest.service.SimpleCalculation;

@ExtendWith(MockitoExtension.class)
class SimpleCalculationMockTest_Simple2 {
	
	@InjectMocks
	SimpleCalculation simpleCalculation;
	
	@Mock
	DataService dataService;
	
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
