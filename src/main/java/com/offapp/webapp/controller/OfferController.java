package com.offapp.webapp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.offapp.webapp.model.Offer;
import com.offapp.webapp.repository.OfferRepository;
import com.offapp.webapp.service.OfferService;

@Controller
@RequestMapping ("/offer")
public class OfferController {

	private OfferService offerService;
	private OfferRepository offerRepository;

	@Autowired
	public OfferController(OfferService offerService, OfferRepository offerRepository) {
		this.offerService = offerService;
		this.offerRepository = offerRepository;
	}
	
	// FILTER OFFER BY TYPE
	@GetMapping (value = "/type/{type}")
	public String listOffers(@PathVariable(value = "type") String type, Model model) {
		model.addAttribute("offers", offerService.listOffers(type));
		return "offerList";
	}
	
	// REDIRECT TO NEW OFFER FORM
	@RequestMapping (value = "/new", method = RequestMethod.GET)
	public String newOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "newOffer";
	}
	
	// CREATE OFFER
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
	
	// UPDATE OFFER
	@RequestMapping (value = "/update/{id}", method = RequestMethod.GET)
	public String updateOffer(@PathVariable(name = "id", required = true) Long id, Model model) {
		Optional<Offer> offerOp = offerRepository.findById(id);
		if (!offerOp.isPresent())
			return "redirect:errorPage";

		model.addAttribute("offer", offerOp.get());
		return "updateOffer";
	}
	
	// SAVE OFFER
	@PostMapping("/save")
	public String saveOffer(@Validated Offer offer, Model model) {
		offerService.save(offer);
		return "redirect:/";
	}	
	
	// DELETE OFFER
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String deleteOffer(@PathVariable(value = "id") Long id, Model model) {
		offerService.deleteOfferById(id);
		return "redirect:/";
	}

	// SEARCH OFFER BY MATCHER
	@PostMapping(value = "/search")
	public String searchOffer(@RequestParam(value = "search") String search, Model model) {
		List<Offer> searchRes = offerService.sBar(search);
		model.addAttribute("offer", searchRes);
		return "searchRes";
	}
}
