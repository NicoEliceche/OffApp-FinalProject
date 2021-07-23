package com.offapp.webapp.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public Offer save(Offer offer) {
		return offerRepository.saveAndFlush(offer);
	}
	
	public List<Offer> listOffers() {
		return offerRepository.findAll();
	}
	
	public List<Offer> listOffers(String type) {
		List<Offer> offer = new ArrayList<Offer>();
	    for (Offer o : offerRepository.findAll()) {
	         if (type.equals(o.getType()))
	       	  offer.add(o);
	    }
	    if (offer.isEmpty())
	    	return null;
	     else	
	    	return offer;
	}
	
}
