package com.aziz.unittest.restcontrollertest.eksperimen;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResult = "{\"id nya\":1,\"tipe\":\"buku\",\"nama\":\"belajar membaca\"}";
	
	@Test
	void jsonAssert_strictTrue() throws JSONException {
		// strict true berarti setiap name dan valuenya harus sama dan lengkap seperti actual
		String expectedResult = "{\"id nya\":1,\"tipe\":\"buku\",\"nama\":\"belajar membaca\"}";
		JSONAssert.assertEquals(expectedResult, actualResult, true);
	}
	
	@Test
	void jsonAssert_strictFalse() throws JSONException {
		//strict false berarti name dan valuenya mesti sama tapi bisa di cek berdasarkan name dan value tertentu aja
		String expectedResult = "{\"id nya\":1,\"tipe\":\"buku\"}";
		JSONAssert.assertEquals(expectedResult, actualResult, false);
	}
	
	@Test
	void jsonAssert_withoutEscapeChar() throws JSONException {
		//bisa tidak pake escape charater asalkan tidak ada spasi di name ataupun di valuenya, kalo ada spasi mesti pake
		String expectedResult = "{\"id nya\":1,tipe:buku,nama:\"belajar membaca\"}";
//		String expectedResult = "{id:1,tipe:buku}";
		JSONAssert.assertEquals(expectedResult, actualResult, false);
	}
	
}
