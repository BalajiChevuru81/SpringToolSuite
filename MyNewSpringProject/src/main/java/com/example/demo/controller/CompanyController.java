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

import com.example.demo.dao.CompanyRepository;
import com.example.demo.pojos.Company;


@RestController


public class CompanyController {

	@Autowired
	 private CompanyRepository companyRepository;

	 @RequestMapping("/getAllUsers")

	 public Iterable<Company> getAllUsers(){

	 return companyRepository.findAll();

	 }
	 @PostMapping("/saveuser")

	 public Company saveUser(@RequestBody Company company)

	 {

	  System.out.println(company);

	  companyRepository.save(company);

	  return company;
	  	 }
	 	 
	 @PutMapping("/updateuser/{companyName}")

	 public Company updateUser(@RequestBody Company company,@PathVariable("companyName") String companyName) {

		 company.setCompanyName(companyName);
	  System.out.println(company);

	  companyRepository.save(company);
	 
	  return company;
	  	 }
	 
	 
/*	 @DeleteMapping("/deleteUser/{username}")
	 
		 public Boolean deleteUser(@PathVariable("companyName") String username) {
			 System.out.println(username);
			 companyRepository.deleteById(companyName);
			 return true;
		 }*/
	 	
}