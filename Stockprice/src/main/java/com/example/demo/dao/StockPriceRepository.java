package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojos.StockPrice;

public interface StockPriceRepository extends CrudRepository<StockPrice,String> {
	
	Iterable<StockPrice> findAll();

	List<StockPrice> findByCompanyname(String companyname);

}