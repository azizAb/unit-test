package com.aziz.unittest.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aziz.unittest.repository.ItemRepository;

@Component
public class BusinessService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Buku hardcodedItem() {
		return new Buku(1, "belajar ms word", 2, 20000);
	}
	
	public List<Buku> retrievAllItem(){
		List<Buku> listbuku = itemRepository.findAll();
		
		for(Buku buku : listbuku) {
			buku.setValue(buku.getHarga() * buku.getJumlah());
		}
		
		
		return itemRepository.findAll();
	}

}
