package com.offapp.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.offapp.webapp.model.Alert;
import com.offapp.webapp.service.AlertService;

@Controller
@RequestMapping("/alert")
public class AlertController {

	private final AlertService alertService;
	
	@Autowired
	public AlertController(AlertService alertService) {
		this.alertService = alertService;
	}
	
	@RequestMapping (value ="/new", method = RequestMethod.GET)
	public String createAlert(Model model) {
		model.addAttribute("alerts", new Alert());
		return "newAlert";
	}
	
	@PostMapping(value = "/create")
	public String createAlert(@RequestParam(value = "description") String description, 
			@RequestParam(value = "wspRadio") Boolean wspRadio, 
			@RequestParam(value = "emailRadio") Boolean emailRadio, Model model) {

		Alert alert = new Alert();
		alert.setDescription(description);
		alert.setWspRadio(wspRadio);
		alert.setEmailRadio(emailRadio);

		alert = alertService.save(alert);
		
		model.addAttribute("alert", alert);
		System.out.println(String.format("Se creó la oferta con id: %s", alert.getId()));
		return "redirect:/alert/new";
	}
}
