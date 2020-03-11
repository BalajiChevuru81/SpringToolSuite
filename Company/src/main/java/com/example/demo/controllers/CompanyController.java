package com.example.demo.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.JSONCompanyClient;
import com.example.demo.dao.CompanyRepository;
import com.example.demo.pojos.Company;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Company")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	JSONCompanyClient jcompany;
	@RequestMapping("/getAllCompanies")
	public Iterable<Company> getAllCompanies(){
		return companyRepository.findAll();
	}
	
	@PostMapping("/saveCompany")
	public  Company saveCompany(@RequestBody Company company) {
		System.out.println(company);
		companyRepository.save(company);
		return company;
	}
	 
	
	@PutMapping("/updateCompany/{companyname}")
	public Company updateCompany(@RequestBody Company company,@PathVariable("companyname") String companyname) {
		company.setCompanyname(companyname);
		System.out.println(company);
		
		companyRepository.save(company);
		return company;
	}
	@DeleteMapping("/deleteCompany/{companyname}")
	public Boolean deleteCompany(@PathVariable("companyname") String companyname) {
		System.out.println(companyname);
		companyRepository.deleteById(companyname);
		return true;
	}

	@GetMapping("/findOneInAll1/{companyname}")

	 public Company findoneinall(@PathVariable("companyname") String companyname) {
	 Optional<Company> company = companyRepository.findById(companyname);
	 Company comp=company.get();
	 comp.setStockPriceList(jcompany.findByCompanyname(companyname));
	 return company.get();
	 }
	
}
