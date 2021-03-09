package com.aziz.unittest.simpleCalculation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.aziz.unittest.model.DataService;
import com.aziz.unittest.service.SimpleCalculation;

// Kekurangannya, jadi mesti banyak implement + kalo di interfacenya nambah method, diclass implement harus nambah juga

class DataServiceStub implements DataService{

	@Override
	public int[] getAllData() {
		return new int[] {2,3,2};
	}
	
}

class DataServiceEmptyStub implements DataService{

	@Override
	public int[] getAllData() {
		return new int[] {};
	}
	
}

class DataServiceOneValueStub implements DataService{

	@Override
	public int[] getAllData() {
		return new int[] {3};
	}
	
}

class SimpleCalculationStubTest {

	@Test
	void calculateSumUseDataService_multipleValue() {
		SimpleCalculation simpleCalculation = new SimpleCalculation();
		simpleCalculation.setCalculateEntity(new DataServiceStub());
		int result = simpleCalculation.calculateSumUseEntity();
		int expectedResult = 7;
		assertEquals(expectedResult, result);
	}
	
	@Test
	void calculateSumUseDataService_empty() {
		SimpleCalculation simpleCalculation = new SimpleCalculation();
		simpleCalculation.setCalculateEntity(new DataServiceEmptyStub());
		int result = simpleCalculation.calculateSumUseEntity();
		int expectedResult = 0;
		assertEquals(expectedResult, result);
	}
	
	@Test
	void calculateSumUseDataService_oneValue() {
		SimpleCalculation simpleCalculation = new SimpleCalculation();
		simpleCalculation.setCalculateEntity(new DataServiceOneValueStub());
		int result = simpleCalculation.calculateSumUseEntity();
		int expectedResult = 3;
		assertEquals(expectedResult, result);
	}
	
}
