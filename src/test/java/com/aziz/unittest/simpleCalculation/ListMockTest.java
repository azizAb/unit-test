package com.aziz.unittest.simpleCalculation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ListMockTest {

	List<String> mock = Mockito.mock(List.class);
	
	@Test
	void singleTest() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	void returnDifferent() {
		when(mock.size()).thenReturn(5).thenReturn(7);
		assertEquals(5, mock.size());
		assertEquals(7, mock.size());
	}

	@Test
	void returnParameter() {
		when(mock.get(0)).thenReturn("mantap");
		assertEquals("mantap", mock.get(0));
	}
	
	// anyint berarti diinput parameter int apa aja bisa. yg penting int.
	@Test
	void returnWithGenericParameter() {
		when(mock.get(anyInt())).thenReturn("mantap");
		assertEquals("mantap", mock.get(0));
		assertEquals("mantap", mock.get(1));
	}
	
	// untuk memverifikasi berapa kali class yang dimocking dipanggil atau list keberapa yang dipanggil
	@Test
	void verificationBasic() {
		//ceritanya running program
		String value1 = mock.get(0);
		
		//di junit di verify
		verify(mock).get(0);
		verify(mock, times(1)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, never()).get(1);
	}
	
	@Test
	void argumentCapture() {
		//ceritanya running program
		mock.add("boleh juga");
		
		//dicapture apa yg di set ke suatu variable
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("boleh juga", captor.getValue());
	}
	
	@Test
	void multipleArgumentCapture() {
		//ceritanya running program
		mock.add("boleh juga");
		mock.add("boleh juga deh");
		
		//dicapture apa yg di set ke suatu variable
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> listValue = captor.getAllValues();
		
		assertEquals("boleh juga", listValue.get(0));
		assertEquals("boleh juga deh", listValue.get(1));
	}
	
	@Test
	void spying() {
		//untuk melihat apa saja yg terjadi diclass yang di spy (parameter apa aja yang ditambahkan)
		//ArrayList sebagai contoh class yang digunakan didalam program
		ArrayList arrayListSpy = spy(ArrayList.class);
		
		arrayListSpy.add("nambah1");
		System.out.println(arrayListSpy.get(0));
		
		// bisa juga dipake buat mocking
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
		//diverify
		verify(arrayListSpy).add("nambah1");
	}
}
