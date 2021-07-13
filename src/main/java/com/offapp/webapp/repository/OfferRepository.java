package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	
}
