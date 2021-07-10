package com.offapp.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.offapp.webapp.model.Category;
import com.offapp.webapp.model.Offer;
import com.offapp.webapp.repository.OfferRepository;

@Controller
@RequestMapping ("/offer")
public class OfferController {

	@Autowired
	private OfferRepository offerRepository;
	
	@RequestMapping ("/list")
	public List<Offer> searchOffers(Double lat, Double len, Category cat) {
		return offerRepository.findAll();
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "newOffer";
	}
}
