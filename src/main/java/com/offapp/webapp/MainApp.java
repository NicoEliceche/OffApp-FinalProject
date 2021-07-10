package com.offapp.webapp;

import com.offapp.webapp.model.Store;

public class MainApp {

	public static void main(String[] args) {
		Store kiosc1 = new Store();
		kiosc1.setName("Lo de Nico");
		kiosc1.setAddress(25, 38);
		
		Store fer = new Store();
		fer.setName("Agrofer");
		fer.setAddress(22, 33);
		
		Store fiam = new Store();
		fiam.setName("Fiambres Juan");
		fiam.setAddress(52, 12);
		
		System.out.println("Localidades: \n" + kiosc1.getAddress() + "\n" + fer.getAddress() + "\n" +  fiam.getAddress());
	}

}
