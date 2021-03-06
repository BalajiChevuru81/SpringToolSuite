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

import com.example.demo.dao.StockPriceDetailsExcelRepository;
import com.example.demo.pojos.StockPriceDetailsExcel;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/getAllStockPriceDetailsExcel")

public class StockPriceDetailsExcelController {

	@Autowired

	private StockPriceDetailsExcelRepository stockPriceDetailsExcelRepository ;

	 @RequestMapping("/getAllStockPriceDetailsExcel")

	 public Iterable<StockPriceDetailsExcel> getAllStockPriceDetailsExcel(){

	 return stockPriceDetailsExcelRepository.findAll();

	 }
	 @PostMapping("/saveStockPriceDetailsExcel")

	 public StockPriceDetailsExcel stockPriceDetailsExcel(@RequestBody StockPriceDetailsExcel stockPriceDetailsExcel)

	 {

	  System.out.println(stockPriceDetailsExcel);

	  stockPriceDetailsExcelRepository.save(stockPriceDetailsExcel);

	  return stockPriceDetailsExcel;
	  	 }
	 	 
	 @PutMapping("/updateStockPriceDetailsExcel/{companyCode}")

	 public StockPriceDetailsExcel updateStockPriceDetailsExcel(@RequestBody StockPriceDetailsExcel stockPriceDetailsExcel,@PathVariable("companyCode") Integer companyCode) {

		 stockPriceDetailsExcel.setCompanyCode(companyCode);
	  System.out.println(companyCode);

	  stockPriceDetailsExcelRepository.save(stockPriceDetailsExcel);
	 
	  return stockPriceDetailsExcel;
	  	 }
	 
	 @DeleteMapping("/deleteStockPriceDetailsExcel/{companyCode}")
		public Boolean deleteStockPriceDetailsExcel(@PathVariable("companyCode") Integer companyCode) {
			System.out.println(companyCode);
			stockPriceDetailsExcelRepository.deleteById(companyCode);
			return true;
		}
	 
		@GetMapping("/findOneInAll5/{companyCode}")
		public StockPriceDetailsExcel findoneinall(@PathVariable("companyname") Integer companyCode) {
			Optional<StockPriceDetailsExcel> stockPriceDetailsExcel = stockPriceDetailsExcelRepository.findById(companyCode);
			return stockPriceDetailsExcel.get();
		}
	
}
