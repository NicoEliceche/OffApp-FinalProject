package com.offapp.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.offapp.webapp.model.Offer;
import com.offapp.webapp.service.OfferService;

@Controller
@RequestMapping ("/offer")
public class OfferController {

	private OfferService offerService;

	@Autowired
	public OfferController(OfferService offerService) {
		this.offerService = offerService;
	}
	
	@GetMapping (value = "/tipo/{type}")
	public String listOffers(@PathVariable(value = "type") String type, Model model) {
		model.addAttribute("offers", offerService.listOffers(type));
		return "offerList";
	}
	
	@RequestMapping (value = "/new", method = RequestMethod.GET)
	public String newOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "newOffer";
	}
	
	@PostMapping(value = "/create")
	public String createOffer(@RequestParam(value = "top") Integer top,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "image") String image,
			@RequestParam(value = "author") String author,
			@RequestParam(value = "description") String description, 
			@RequestParam(value = "offPrice") Double offPrice, 
			@RequestParam(value = "origPrice") Double origPrice, Model model) {

		Offer offer = new Offer();
		offer.setTop(top);
		offer.setType(type);
		offer.setImage(image);
		offer.setAuthor(author);
		offer.setDescription(description);
		offer.setOffPrice(offPrice);
		offer.setOrigPrice(origPrice);

		offer = offerService.save(offer);
		
		model.addAttribute("offer", offer);
		System.out.println(String.format("Se creó la oferta con id: %s", offer.getId()));
		return "redirect:/offer/new";
	}
	
	

}
