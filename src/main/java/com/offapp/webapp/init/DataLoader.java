package com.offapp.webapp.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.offapp.webapp.model.Product;
import com.offapp.webapp.repository.ProductRepository;

@Component
public class DataLoader {

	private ProductRepository productRepository;
	
	public DataLoader(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public void run (ApplicationArguments args) {
		
	}
	
}
