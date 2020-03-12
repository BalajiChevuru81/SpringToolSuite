package com.example.demo.pojos;

import java.sql.Time;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity

@Table(name = "stockprice")

public class StockPrice {


	private String companyname;
	private String stockexchange;
	private int currentprice;
	private String date;
	private String time;
	private String uplodefile; 
	
	public String getUplodefile() {
		return uplodefile;
	}
	public void setUplodefile(String uplodefile) {
		this.uplodefile = uplodefile;
	}
	@Override
	public String toString() {
		return "StockPrice [companyname=" + companyname + ", stockexchange=" + stockexchange + ", currentprice="
				+ currentprice + ", date=" + date + ", time=" + time + ", uplodefile=" + uplodefile + "]";
	}
	@Id
	
	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}
	
	

	public String getCompanyname() {

		return companyname;

	}

	public void setCompanyname(String companyname) {

		this.companyname= companyname;

	}

	

	public int getCurrentprice() {

		return currentprice;

	}

	public void setCurrentprice(int currentprice) {

		this.currentprice = currentprice;

	}

	public String getDate() {

		return date;

	}

	public void setDate(String date) {

		this.date = date;

	}

	public String getTime() {

		return time;

	}

	public void setTime(String time) {

		this.time = time;

	}

}
