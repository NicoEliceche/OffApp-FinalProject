package com.offapp.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offapp.webapp.service.OfferService;

@Controller
@RequestMapping("/")
public class MainController {

	private final OfferService offerService;
	
	@Autowired
	public MainController(OfferService offerService) {
		this.offerService = offerService;
	}
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("offers", offerService.listOffers());
		return "index";
	}
	
	@GetMapping(value = "/friend_businesses")
	public String friend_businesses() {
		return "friend_businesses";
	}
	
	@GetMapping(value = "/create_your_alert")
	public String create_your_alert() {
		return "create_your_alert";
	}
	
	@GetMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping(value = "/social_media")
	public String social_media() {
		return "social_media";
	}
	
	@GetMapping(value = "/about_us")
	public String about_us() {
		return "about_us";
	}
	
}