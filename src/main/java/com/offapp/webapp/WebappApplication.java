package com.offapp.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.offapp.webapp.model.Product;
import com.offapp.webapp.model.Store;
import com.offapp.webapp.model.Type;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
		
		Store meca = new Store();
		meca.setName("MecaNico");
		meca.setAddress(25, 38);
		
		Store fer = new Store();
		fer.setName("Agrofer");
		fer.setAddress(22, 33);
		
		Store fiam = new Store();
		fiam.setName("Fiambres Juan");
		fiam.setAddress(52, 12);
		
		Type Alfajor = new Product();
		Alfajor.setName("Alfajor Fantoche");
		
	}

}
