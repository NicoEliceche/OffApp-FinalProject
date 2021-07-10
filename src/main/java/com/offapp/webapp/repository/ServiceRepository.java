package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
	
}
