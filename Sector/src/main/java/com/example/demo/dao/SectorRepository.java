package com.example.demo.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojos.Sector;

public interface SectorRepository extends CrudRepository<Sector,Integer> {
	
	Iterable<Sector> findAll();

}
