package com.example.demo.dao;



import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojos.Company;

public interface CompanyRepository extends CrudRepository<Company,String> {
	
	Iterable<Company> findAll();
}

