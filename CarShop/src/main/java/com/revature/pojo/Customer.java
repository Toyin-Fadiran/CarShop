package com.revature.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

	private List<Car> purchasedCars = new ArrayList<>();
	private Boolean pendingOffer;
	public boolean ownCar = false;
	Inventory i;
	
	



	@Override
	public String toString() {
		return "Customer [ownCar=" + ownCar + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


	public Boolean getOwnCar() {
		return ownCar;
	}


	public void setOwnCar(Boolean ownCar) {
		this.ownCar = ownCar;
	}





	UserInventory c = UserInventory.getInstance();
	//public Car car;
	
	public List<Car> getPurchasedCars() {
		return purchasedCars;
	}


	public void setPurchasedCars(List<Car> purchasedCars) {
		this.purchasedCars = purchasedCars;
	}


	public Boolean getPendingOffer() {
		return pendingOffer;
	}


	public void setPendingOffer(Boolean pendingOffer) {
		this.pendingOffer = pendingOffer;
	}





	public Customer(String first, String last, String pass, Car car, Inventory i) {
		super(first, last, pass, car);
		c.users.add(this);
		i.getCustomers().add(this);
		
		this.setUserType("Customer");
	}


}
