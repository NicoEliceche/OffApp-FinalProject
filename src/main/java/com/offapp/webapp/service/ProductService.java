package com.offapp.webapp.service;

import java.util.List;

import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offapp.webapp.model.Product;
import com.offapp.webapp.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository =  productRepository;
	}
	
	public List<Product> listProducts() {
		return productRepository.findAll();
	}
	
}
