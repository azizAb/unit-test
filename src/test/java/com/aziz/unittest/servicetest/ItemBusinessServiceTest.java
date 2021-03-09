package com.aziz.unittest.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aziz.unittest.model.Buku;
import com.aziz.unittest.model.BusinessService;
import com.aziz.unittest.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	@InjectMocks
	private BusinessService businessService;
	
	@Mock
	private ItemRepository itemRepo;
	
	@Test
	void retrievAllBookService() {
		when(itemRepo.findAll()).thenReturn(Arrays.asList(new Buku(1, "belajar gambar", 1, 10000),
				(new Buku(2, "belajar nulis", 2, 10000))));
		List<Buku> ListBuku = businessService.retrievAllItem();
		
		assertEquals(10000, ListBuku.get(0).getValue());
		assertEquals(20000, ListBuku.get(1).getValue());
		
	}
	
}
