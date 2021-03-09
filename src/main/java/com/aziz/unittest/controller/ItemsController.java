package com.aziz.unittest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.unittest.model.Buku;
import com.aziz.unittest.model.BusinessService;

@RestController
public class ItemsController {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/getitem")
	public Buku getItem() {
		
		return new Buku(1, "belajar ms word", 2, 20000);
		
	}
	
	@GetMapping("/getitemfromservice")
	public Buku getItemFromService() {
		
		return businessService.hardcodedItem();
		
	}

	@GetMapping("/getAllItemFromDB")
	public List<Buku> getItemFromDB() {
		
		List<Buku> listItem = businessService.retrievAllItem();
		
		return listItem;
		
	}
	
}
