package com.offapp.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offapp.webapp.model.Category;
import com.offapp.webapp.model.Product;
import com.offapp.webapp.repository.ProductRepository;

@Controller
@RequestMapping ("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping ("/list")
	public List<Product> searchOffers(double lat, double len, Category cat) {
		return productRepository.findAll();
	}

}
