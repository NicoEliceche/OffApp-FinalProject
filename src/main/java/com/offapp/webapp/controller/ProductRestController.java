package com.offapp.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offapp.webapp.model.Product;
import com.offapp.webapp.repository.ProductRepository;

@RestController
@RequestMapping("api/v1/products/list")
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping ("")
		public ResponseEntity<List<Product>> listProducts() {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}

}
