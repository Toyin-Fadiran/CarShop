package com.revature.ui;

import com.revature.pojo.Inventory;
import com.revature.pojo.User;
import com.revature.services.UserService;
import com.revature.util.TextValidator;

public class LoginScreen implements Screen {

	Inventory I2;
	public LoginScreen(Inventory I) {
		I2 = I;
		display(I2);
	}

	@Override
	public Screen display(Inventory I2) {
		TextValidator t = TextValidator.getInstance();
		UserService s = UserService.getInstance();
		while(true) {
		String tempFirst = t.askForString(1, 25, "LOGIN: PLEASE ENTER  NAME: ");
		//tempUser = s.getByFirstName(tempFirst);
		User tempUser = s.getByFirstName(tempFirst);
		
		if (tempUser == null) continue; 
		String tempPass = t.askForString(1, 25, "Please enter your password.");
		
		if (  tempUser.getFirstName().equals("admin") && tempPass.equals("admin")   ) {
			return new EmployeeScreen(I2);
		}
		if (tempPass.equals(tempUser.getPassword() )){
			return new DashboardScreen(I2);
		}
		//
		//if(tempPass.equals("admin")) {
		//	return new EmployeeScreen();
	//	}
	}
	
	}

	

	@Override
	public void printDisplay(Inventory I2) {
		
		// TODO Auto-generated method stub
	
		
	}

}
