package com.offapp.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.offapp.webapp.model.Product;
import com.offapp.webapp.model.Type;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
		
		Product p1 = new Product();
		p1.setName("Alfajor Grandote");
		
	}

}
