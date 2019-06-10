package com.revature.pojo;

import java.util.HashMap;
import java.util.Map;

public class Car {

	private String Name;
	private String accountID;
	private Double price;
	private boolean offerFlag;
	CarLot cl = CarLot.getInstance();
	
	Map <String, Double> madeOffers = new HashMap<String, Double>();
	//ArrayList
	private Double monthsNeeded;
	//String remainPayments;
	
	
	public Double getMonthsNeeded() {
		return monthsNeeded;
	}

	public void setMonthsNeeded(Double monthsNeeded) {
		this.monthsNeeded = monthsNeeded;
	}

	public Car() {
		super();
	}

	public Car( String accountID, String name, Double price, Inventory i) {
		super();
		Name = name;
		this.accountID = accountID;
		this.price = price;
		this.offerFlag = false;
		cl.carLot.put(accountID, this);
		//i.cars.add(this);
		i.getCars().add(this);
	}

	public boolean isOfferFlag() {
		return offerFlag;
	}

	public void setOfferFlag(boolean offerFlag) {
		this.offerFlag = offerFlag;
	}

	@Override
	public String toString() {
		return "Car [Name=" + Name + ", accountID=" + accountID + ", price=" + price 
				+ ", offerFlag=" + offerFlag + "]";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Map<String, Double> getMadeOffers() {
		return madeOffers;
	}

	public void setMadeOffers(Map<String, Double> madeOffers) {
		this.madeOffers = madeOffers;
	}

	
	public void addMadeOffer(String s, double inputOffer) {
		madeOffers.put(s, inputOffer);
		
	}
		

}
