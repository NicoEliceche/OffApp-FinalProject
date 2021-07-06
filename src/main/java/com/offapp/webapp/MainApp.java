package com.offapp.webapp;

import com.offapp.webapp.model.Location;
import com.offapp.webapp.model.Store;

public class MainApp {

	public static void main(String[] args) {
		Location l = new Location();
		l.setLat(234.54);
		l.setLen(345.21);
		
		Store kiosk = new Store();
		kiosk.setName("Niosco");
		
		System.out.println(l.getLocation(kiosk.getName()));
		
	}

}
