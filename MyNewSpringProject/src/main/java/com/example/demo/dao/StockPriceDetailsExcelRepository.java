package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojos.StockPriceDetailsExcel;

public interface StockPriceDetailsExcelRepository extends CrudRepository<StockPriceDetailsExcel, Integer> {

	Iterable<StockPriceDetailsExcel> findAll();
}