package com.aziz.unittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aziz.unittest.model.Buku;

@Repository
public interface ItemRepository extends JpaRepository<Buku, Integer>{

}
