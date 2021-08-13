package com.offapp.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offapp.webapp.model.Offer;
import com.offapp.webapp.repository.OfferRepository;

@Service
public class OfferService {

	private final OfferRepository offerRepository;

	@Autowired
	public OfferService(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	// SAVE OFFER
	public Offer save(Offer offer) {
		return offerRepository.saveAndFlush(offer);
	}
	
	// LIST OFFERS
	public List<Offer> listOffers() {
		return offerRepository.findAll();
	}
	
	public List<Offer> listOffers(String type) {
		List<Offer> offer = new ArrayList<Offer>();
		offer = offerRepository.findByTypeIgnoreCase(type);
	    return offer;
	}
	
	// UPDATE OFFER
	public Optional<Offer> getId(Long id) {
		return offerRepository.findById(id);
	}
	
	// SEARCH BAR
	public List<Offer> sBar (String search) {
		return offerRepository.findAllByMatchers(search);
	}
	
	// DELETE OFFER
	public void deleteOfferById(Long id) {
		offerRepository.deleteById(id);
	}
	
}
