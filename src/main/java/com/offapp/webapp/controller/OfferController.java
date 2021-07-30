package com.offapp.webapp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//FILTER OFFER BY TYPE
	@GetMapping (value = "/type/{type}")
	public String listOffers(@PathVariable(value = "type") String type, Model model) {
		model.addAttribute("offers", offerService.listOffers(type));
		return "offerList";
	}
	
	//REDIRECT TO NEW OFFER FORM
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
	
//	// UPDATE OFFER
//	@PostMapping("/{id}")
//	public String updateOffer(@PathVariable(name = "id", required = true) Long id, @ModelAttribute(name = "offer") Offer offer) {
//		Optional<Offer> offerOp = offerService.findOfferById(id);
//	if (offerOp.isPresent() || offer == null)
//		return "redirect:/error";
//		
//	Offer offerRepo = offerOp.get();
//	offerRepo.setAuthor(offer.getAuthor());
//	offerRepo.setDescription(offer.getDescription());
//	offerRepo.setOffPrice(offer.getOffPrice());
//	offerRepo.setOrigPrice(offer.getOrigPrice());
//	offerService.save(offer);
//	return "redirect:/";
//	}
//	
////	DELETE METHOD
//	@DeleteMapping("/{id}")
//	public String deleteOffer(@PathVariable(name = "id", required = true) Long id, Model model) {
//		Optional<Offer> offerOp = offerService.findOfferById(id);
//		if (!offerOp.isPresent())
//			return "redirect:/error";
//		Offer offer = offerOp.get();
//		offer.setDelete(true);
//		offerService.save(offer);
//		model.addAttribute("offer", offerOp.get());
//		return "editOffer";
//	}
	
//	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
//	public String delOffer(@PathVariable(value = "id") Long id, Model model) {
//		Offer offer = offerService.findOfferById(id);
//		offerService.deleteById(offer);
//		return "redirect:/";
//	}

	//SEARCH OFFER BY MATCHER
	@PostMapping(value = "/search")
	public String searchOffer(@RequestParam(value = "search") String search, Model model) {
		List<Offer> searchRes = offerService.sBar(search);
		model.addAttribute("offer", searchRes);
		return "searchRes";
	}
}
