package com.aziz.unittest.repositorytest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.aziz.unittest.model.Buku;
import com.aziz.unittest.repository.ItemRepository;

@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void testFindAll() {
		List<Buku> listBuku = itemRepository.findAll();
		assertEquals(2, listBuku.size());
	}
	

}
