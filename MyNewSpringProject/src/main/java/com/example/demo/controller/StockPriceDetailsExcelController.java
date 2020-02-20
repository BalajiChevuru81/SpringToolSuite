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

import com.example.demo.dao.StockPriceDetailsExcelRepository;
import com.example.demo.pojos.StockPriceDetailsExcel;


@RestController

public class StockPriceDetailsExcelController {

	@Autowired

	private StockPriceDetailsExcelRepository stockPriceDetailsExcelRepository ;

	 @RequestMapping("/getAllUsers")

	 public Iterable<StockPriceDetailsExcel> getAllUsers(){

	 return stockPriceDetailsExcelRepository.findAll();

	 }
	 @PostMapping("/saveuser")

	 public StockPriceDetailsExcel stockPriceDetailsExcel(@RequestBody StockPriceDetailsExcel stockPriceDetailsExcel)

	 {

	  System.out.println(stockPriceDetailsExcel);

	  stockPriceDetailsExcelRepository.save(stockPriceDetailsExcel);

	  return stockPriceDetailsExcel;
	  	 }
	 	 
	 @PutMapping("/updateuser/{companyCode}")

	 public StockPriceDetailsExcel updateUser(@RequestBody StockPriceDetailsExcel stockPriceDetailsExcel,@PathVariable("companyCode") Integer companyCode) {

		 stockPriceDetailsExcel.setCompanyCode(companyCode);
	  System.out.println(companyCode);

	  stockPriceDetailsExcelRepository.save(companyCode);
	 
	  return stockPriceDetailsExcel;
	  	 }
	
}