package com.revature.ui;

import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Customer;
import com.revature.pojo.Inventory;
import com.revature.pojo.User;
import com.revature.services.UserService;
import com.revature.services.ViewServiceImpl;
import com.revature.util.Driver;
import com.revature.util.TextValidator;

public class DashboardScreen implements Screen {

//	private static final Scanner SCAN = new Scanner(System.in);
Inventory I3;
	public DashboardScreen(Inventory i) {
		// TODO Auto-generated constructor stub
		I3 = i;
		printDisplay(I3);
	}

	@Override
	public Screen display(Inventory I3) {
		// TODO Auto-generated method stub
		TextValidator t = TextValidator.getInstance();
		ViewServiceImpl v = ViewServiceImpl.getInstance();
		int choice = t.askForInt(0, 4, "Please Select Choice", "View Cars on Lot", "Make Offer on Car");
		switch (choice){
		case 0:
			Driver.idao.saveFile(I3);
			System.exit(0);
		case 1:
			List<Car> printCarLot = v.getAllAccounts(); for (Car c: printCarLot) {
				System.out.println(c); } 

			//vs.viewCarLot(generic);
			return new LoginScreen(I3);
		case 2:

			return new RegisterScreen(I3);
		}	
		return null;
	}

	@Override
	public void printDisplay(Inventory I3) {

		// TODO Auto-generated method stub
		TextValidator t = TextValidator.getInstance();
		ViewServiceImpl v = ViewServiceImpl.getInstance();
		UserService s = UserService.getInstance();
		int choice = t.askForInt(0, 5, "Please Select a car Choice", "View Cars on Lot",
				"Make Offer on Car", "View Cars I Own", "Logout");
		switch (choice){
		case 0:
			Driver.idao.saveFile(I3);
			System.exit(0);
		case 1:
			List<Car> printCarLot = v.getAllAccounts(); for (Car c: printCarLot) {
				System.out.println(c); } 
			//vs.viewCarLot(generic);
			break;
		case 2:
			//System.out.println("Please enter your name bro");
			String tempFirst = t.askForString(1, 25, "Please enter your name broski");
			//String tempFirst = SCAN.nextLine();
			// = s.getByFirstName(tempFirst);
			User tempUser = s.getByFirstName(tempFirst);

			String tempOfferString = t.askForString(1, 25, "Please enter car ID");
			Car tempOfferCar = v.retrieve(tempOfferString);
			tempOfferCar.setOfferFlag(true);

			double tempOfferAmt = t.askForDouble(0, 100000.0, "What is your offer price?");
			if (tempUser.getUserType() == "Customer") {
				Customer tempCustomer = (Customer) tempUser;
				String offerName = tempCustomer.getFirstName();
				tempOfferCar.addMadeOffer(offerName, tempOfferAmt);
			}	
			break;
		case 3:
			String temp2First = t.askForString(1, 25, "Please enter your name broski");
			User temp2User = s.getByFirstName(temp2First);
			Customer temp2Customer = (Customer) temp2User;
			List<Car> tempCarList = temp2Customer.getPurchasedCars();
			for (Car c: tempCarList ) {
				System.out.println(c);
				double remainingPayments = c.getPrice()/c.getMonthsNeeded();
				System.out.printf("Cost of car: $%,.2f -- remaining payments:$%,.2f\n",
						c.getPrice(), remainingPayments);
				break;	
			}
			
			//List<Car> tempCarList = temp2Customer.getPurchasedCars();
			//for (Car c: tempCarList ) {
				
			//	break;
		//	}
		case 4:
			new LoginScreen(I3);
			break;
		}	
		new DashboardScreen(I3);

	}


}
