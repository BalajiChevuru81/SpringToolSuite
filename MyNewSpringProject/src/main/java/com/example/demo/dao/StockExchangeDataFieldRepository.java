package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojos.StockExchangeDataField;

public interface StockExchangeDataFieldRepository extends CrudRepository<StockExchangeDataField, Integer>{

	Iterable<StockExchangeDataField> findAll();
}
