package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
