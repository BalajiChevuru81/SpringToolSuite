package com.example.demo.controllers;

import java.util.List;
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

import com.example.demo.dao.StockPriceRepository;
import com.example.demo.pojos.StockPrice;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
	
	@Autowired
	private StockPriceRepository stockpriceRepository;
	
	@RequestMapping("/getAllStockPrice")
	public Iterable<StockPrice> getAllStockPrice(){
		return stockpriceRepository.findAll();
	}
	
	@PostMapping("/saveStockPrice")
	public  StockPrice saveStockPrice(@RequestBody StockPrice stockprice) {
		System.out.println(stockprice);
		stockpriceRepository.save(stockprice);
		return stockprice;
	}
	
	@PutMapping("/updateStockPrice/{stockexchange}")
	public StockPrice updateStockPrice(@RequestBody StockPrice stockprice,@PathVariable("stockexchange") String stockexchange) {
		stockprice.setStockexchange(stockexchange);
		System.out.println(stockprice);
		
		stockpriceRepository.save(stockprice);
		return stockprice;
	}
	@DeleteMapping("/deleteStockPrice/{stockexchange}")
	public Boolean deleteStockPrice(@PathVariable("stockexchange") String stockexchange) {
		System.out.println(stockexchange);
		stockpriceRepository.deleteById(stockexchange);
		return true;
	}

	@GetMapping("/findOneInAll5/{stockexchange}")
	public StockPrice findoneinall(@PathVariable("stockexchange") String stockexchange) {
		Optional<StockPrice> stockprice = stockpriceRepository.findById(stockexchange);
		return stockprice.get();
	}
	@GetMapping("/findByCompanyname/{companyname}")

	 public List<StockPrice> findBycompanyname(@PathVariable("companyname") String companyname)
	 {
	 List<StockPrice> stockprice = stockpriceRepository.findByCompanyname(companyname);
	 return stockprice;

	 }
	
}
