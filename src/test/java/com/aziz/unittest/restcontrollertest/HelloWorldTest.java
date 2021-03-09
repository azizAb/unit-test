package com.aziz.unittest.restcontrollertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.aziz.unittest.controller.HelloWorldController;

@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void HelloWorld_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/helloworld")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		
//		MvcResult result = mockMvc.perform(request).andReturn();
//		
//		assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
