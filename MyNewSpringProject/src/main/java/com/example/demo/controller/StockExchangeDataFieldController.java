package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IposRepository;
import com.example.demo.dao.StockExchangeDataFieldRepository;
import com.example.demo.pojos.IposPlanned;
import com.example.demo.pojos.StockExchangeDataField;


@RestController

public class StockExchangeDataFieldController {

	@Autowired
	
	 private StockExchangeDataFieldRepository stockExchangeDataFieldRepository;

	 @RequestMapping("/getAllUsers")

	 public Iterable<StockExchangeDataField> getAllUsers(){

	 return stockExchangeDataFieldRepository.findAll();

	 }
	 @PostMapping("/saveuser")

	 public StockExchangeDataField stockExchangeDataField(@RequestBody StockExchangeDataField stockExchangeDataField)

	 {

	  System.out.println(stockExchangeDataField);

	  stockExchangeDataFieldRepository.save(stockExchangeDataField);

	  return stockExchangeDataField;
	  	 }
	 	 
	 @PutMapping("/updateuser/{id3}")

	 public StockExchangeDataField updateUser(@RequestBody StockExchangeDataField stockExchangeDataField,@PathVariable("id3") Integer id3) {

		 stockExchangeDataField.setId(id3);
	  System.out.println(id3);

	  stockExchangeDataFieldRepository.save(id3);
	 
	  return stockExchangeDataField;
	  	 }
	
}