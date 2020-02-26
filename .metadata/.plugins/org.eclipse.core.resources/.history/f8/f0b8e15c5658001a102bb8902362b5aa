package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SectorsDataFieldRepository;
import com.example.demo.pojos.SectorDataFields;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/getAllSectorDataFields")

public class SectorDataFieldsController {

	@Autowired
	
	 private SectorsDataFieldRepository sectorDataFieldRespository;

	 @RequestMapping("/getAllUsers")

	 public Iterable<SectorDataFields> getAllUsers(){

	 return sectorDataFieldRespository.findAll();

	 }
	 @PostMapping("/saveSectorDataFields")

	 public SectorDataFields sectorDataField(@RequestBody SectorDataFields sectorDataField)

	 {

	  System.out.println(sectorDataField);

	  sectorDataFieldRespository.save(sectorDataField);

	  return sectorDataField;
	  	 }
	
	 @PutMapping("/updateSectorDataFields/{id2}")

	 public SectorDataFields updateSectorDataFields(@RequestBody SectorDataFields sectorDataField,@PathVariable("id2") Integer id2) {

		 sectorDataField.setId(id2);
		 
	  System.out.println(sectorDataField);

	  sectorDataFieldRespository.save(sectorDataField);
	 
	  return sectorDataField;
	  	 }
	 
	 @DeleteMapping("/deleteSectorDataFields/{id2}")
		public Boolean deleteCompany(@PathVariable("id2") Integer id2) {
			System.out.println(id2);
			Optional<SectorDataFields> sectorDataField = sectorDataFieldRespository.findById(id2);
			sectorDataFieldRespository.delete(sectorDataField.get());
			return true;
		}
		@GetMapping("/findOneInAll3/{sectorid}")
		public SectorDataFields findoneinall(@PathVariable("sectorid") Integer sectorid) {
			Optional<SectorDataFields> sectorDataField = sectorDataFieldRespository.findById(sectorid);
			return sectorDataField.get();
		}
	
}
