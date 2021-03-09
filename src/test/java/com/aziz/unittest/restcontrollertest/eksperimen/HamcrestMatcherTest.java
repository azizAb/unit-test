package com.aziz.unittest.restcontrollertest.eksperimen;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestMatcherTest {
	
	@Test
	void matcherTest() {
		List<Integer> listData = Arrays.asList(11,12,13);
		
		assertThat(listData, hasSize(3));
		assertThat(listData, hasItems(12,13));
		assertThat(listData, everyItem(greaterThan(10)));
		assertThat(listData, everyItem(lessThan(20)));
		
		assertThat("", isEmptyString());
		assertThat("ABCD", containsString("CD"));
		assertThat("ABCDE", startsWith("AB"));
		
	}

}
