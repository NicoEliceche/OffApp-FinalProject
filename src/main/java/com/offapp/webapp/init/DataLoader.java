package com.offapp.webapp.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.offapp.webapp.repository.OfferRepository;

@Component
public class DataLoader {

	private OfferRepository offerRepository;
	
	public DataLoader(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	public void run (ApplicationArguments args) {
		
	}
	
}
