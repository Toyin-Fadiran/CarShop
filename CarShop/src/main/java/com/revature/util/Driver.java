package com.revature.util;

import com.revature.dao.InventoryDAO;
import com.revature.dao.InventorySerializeDAO;
import com.revature.pojo.Inventory;
import com.revature.ui.WelcomeScreen;

public class Driver {

	public static InventoryDAO idao = new InventorySerializeDAO();

	public static void main(String[] args) {
		LoggingUtil.trace("start of the program");
		
		Inventory i;
		
		if(idao.loadFile() == null) {
			
			i = new Inventory();
		} else {
			
			i = idao.loadFile();
		}
		
		
		new WelcomeScreen(i);

}

}