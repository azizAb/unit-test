package com.aziz.unittest.service;

import java.util.Arrays;

import com.aziz.unittest.model.DataService;

public class SimpleCalculation {
	
	private DataService calculateEntity;

	public void setCalculateEntity(DataService calculateEntity) {
		this.calculateEntity = calculateEntity;
	}

	public int calculateSum(int[] listData) {
		
		// functional programing
		return Arrays.stream(listData).reduce(Integer::sum).orElse(0);
		
//		int sum = 0;
//		for(int data:listData) {
//			sum += data;
//		}
//		return sum;
	}
	
	public int calculateSumUseEntity() {
		
		//functional programing
		return Arrays.stream(calculateEntity.getAllData()).reduce(Integer::sum).orElse(0);
//		
//		int sum = 0;
//		int[] listData = calculateEntity.getAllData();
//		
//		for(int data:listData) {
//			sum += data;
//		}
//		return sum;
	}

}
