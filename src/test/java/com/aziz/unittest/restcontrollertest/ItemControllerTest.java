package com.aziz.unittest.restcontrollertest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.aziz.unittest.controller.ItemsController;
import com.aziz.unittest.model.Buku;
import com.aziz.unittest.model.BusinessService;

@WebMvcTest(value = ItemsController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BusinessService businessService;
	
	@Test
	public void GetItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/getitem")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"nama\":\"belajar ms word\",\"jumlah\":2,\"harga\":20000,\"value\":0}"))
				.andReturn();
		
//		MvcResult result = mockMvc.perform(request).andReturn();
//		
//		assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void usingBusinessItem() throws Exception {
		when(businessService.hardcodedItem()).thenReturn(new Buku(1, "belajar ms word", 2, 20000));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/getitemfromservice")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"nama\":\"belajar ms word\",\"jumlah\":2,\"harga\":20000,\"value\":0}"))
				.andReturn();
		
	}

}
