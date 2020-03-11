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
	
	@Override

	public String toString() {

		return "StockPrice [companyname=" + companyname + ", stockexchange=" + stockexchange + ", currentprice="

				+ currentprice + ", date=" + date + ", time=" + time + "]";

	}
	@Id
	private String stockexchange;
	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}
	private String currentprice;
	private Date date;
	private Time time;
	

	public String getCompanyname() {

		return companyname;

	}

	public void setCompanyname(String companyname) {

		this.companyname= companyname;

	}

	

	public String getCurrentprice() {

		return currentprice;

	}

	public void setCurrentprice(String currentprice) {

		this.currentprice = currentprice;

	}

	public Date getDate() {

		return date;

	}

	public void setDate(Date date) {

		this.date = date;

	}

	public Time getTime() {

		return time;

	}

	public void setTime(Time time) {

		this.time = time;

	}

}
