package com.example.demo.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojos.IpoDetails;

public interface IpoDetailsRepository extends CrudRepository<IpoDetails,Integer> {
	
	Iterable<IpoDetails> findAll();

}
