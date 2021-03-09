package com.aziz.unittest.restcontrollertest;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// jika perlu menggunakan spesifik properties
//@TestPropertySource(locations = {"classpath: test-configuration.properties"})
public class IntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void retrievAllData() throws JSONException {
		String response = restTemplate.getForObject("/getAllItemFromDB", String.class);
		JSONAssert.assertEquals("[{id:1},{id:2}]", response, false);
	}
	
}
