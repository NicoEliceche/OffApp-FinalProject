package com.offapp.webapp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.offapp.webapp.model.Offer;
import com.offapp.webapp.service.OfferService;

@Controller
@RequestMapping ("/offer")
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	@RequestMapping ("/list")
	public List<Offer> listOffers() {
		return offerService.listOffers();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "newOffer";
	}
	
	@PostMapping(value = "/create")
	public String createOffer(@RequestParam(value = "author") String author, 
			@RequestParam(value = "description") String description, 
			@RequestParam(value = "offPrice") BigDecimal offPrice, 
			@RequestParam(value = "origPrice") BigDecimal origPrice, Model model) {

		Offer offer = new Offer();
		offer.setAuthor(author);
		offer.setDescription(description);
		offer.setOffPrice(offPrice);
		offer.setOrigPrice(origPrice);

		offer = offerService.save(offer);
		
		model.addAttribute("offer", offer);
		System.out.println(String.format("Se creó la oferta con id: %s", offer.getId()));
		return "redirect:/";
	}
	
}
