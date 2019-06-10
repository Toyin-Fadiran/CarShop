package com.revature.ui;

import com.revature.pojo.Customer;
import com.revature.pojo.Inventory;
import com.revature.services.UserService;
import com.revature.services.ViewServiceImpl;
import com.revature.util.TextValidator;

public class RegisterScreen implements Screen {

	Inventory I2;
	public RegisterScreen(Inventory i) {
		// TODO Auto-generated constructor stub
		I2= i;
		display(I2);
	}

	@Override
	public Screen display(Inventory i) {
		TextValidator t = TextValidator.getInstance();
		UserService s = UserService.getInstance();
		ViewServiceImpl uv = ViewServiceImpl.getInstance();
		while(true) {
			String tempFirst = t.askForString(1, 25, "Welcome to registration! Please enter your first name");
			String tempLast = t.askForString(1, 25, "Please enter your last name");
			String tempPass = t.askForString(1, 25, "Please enter your password.");
			new Customer(tempFirst, tempLast, tempPass, null, i);


			return new WelcomeScreen(i);

		}
	}
	@Override
	public void printDisplay(Inventory i) {

		// TODO Auto-generated method stub

	}


}
