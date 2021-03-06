package com.example.demo.pojos;

//import javax.persistence.Column;

import javax.persistence.Entity;

//import javax.persistence.GeneratedValue;

//import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity

@Table(name="stockexchangedatafields")


public class StockExchangeDataField {
	
	@Id
	
	int id3;
	String stockExchange;
	String breaf;
	String address;
	String remarks;
	@Override
	public String toString() {
		return "StockExchangeDataField [id=" + id3 + ", stockExchange=" + stockExchange + ", breaf=" + breaf
				+ ", address=" + address + ", remarks=" + remarks + "]";
	}
	
	
	public int getId() {
		return id3;
	}
	public void setId(int id) {
		this.id3 = id;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getBreaf() {
		return breaf;
	}
	public void setBreaf(String breaf) {
		this.breaf = breaf;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
