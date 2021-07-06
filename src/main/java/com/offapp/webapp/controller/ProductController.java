package com.offapp.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offapp.webapp.model.Category;
import com.offapp.webapp.model.Product;
import com.offapp.webapp.repository.ProductRepository;

@RestController
@RequestMapping ("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping (value="/")
	public List<Product> searchOffers(double lat, double len, Category cat) {
		return productRepository.findAll();
	}

}
