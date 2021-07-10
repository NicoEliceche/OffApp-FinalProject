package com.offapp.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offapp.webapp.model.Offer;
import com.offapp.webapp.repository.OfferRepository;

@Service
public class OfferService {

private OfferRepository offerRepository;
	
	@Autowired
	public OfferService(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	public List<Offer> listOffers() {
		return offerRepository.findAll();
	}
}
