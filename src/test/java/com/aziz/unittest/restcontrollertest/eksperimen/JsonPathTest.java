package com.aziz.unittest.restcontrollertest.eksperimen;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	void jsonPathTest() {
		
		String responseFromService = "[" + 
				"{\"id\":10,\"name\":\"tomat\",\"quantity\":2}," + 
				"{\"id\":11,\"name\":\"mangga\",\"quantity\":1}," + 
				"{\"id\":12,\"name\":\"apel\",\"quantity\":4}" + 
				"]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		
		int lenght = context.read("$.length()");
		assertThat(lenght).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10,11,12);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:1]").toString());
		System.out.println(context.read("$.[?(@.name=='apel')]").toString());
		
		//search google jsonpath for more $. argument
	}

}
