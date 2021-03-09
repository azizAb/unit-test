package com.aziz.unittest.restcontrollertest.eksperimen;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

// untuk perbandingan dengan assertThat punyanya hamcrest

public class AssertJTest {
	
	@Test
	void matcherTest() {
		
		List<Integer> listData = Arrays.asList(11,12,13);
		assertThat(listData).hasSize(3)
							.contains(12,13)
							// pake lamda untuk ngecek setiap value lebih besar dari 10
							.allMatch(x -> x > 10)
							.allMatch(x -> x < 20)
							// pake lamda untuk ngecek setiap value tidak ada yang kurang dari nol
							.noneMatch(x -> x < 0);
		
		assertThat("ABCDE").contains("CD")
						 .startsWith("AB");
		
	}

}
