package com.offapp.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.offapp.webapp.service.SendMailService;


@Controller
public class SendMailController {

	@Autowired
	private SendMailService sendMailService;
	
	@GetMapping("/newMail")
	public String sendMail() {
		return "newMail";
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body) {
		String message = body + "\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail:" + mail;
		sendMailService.sendMail("nicoelicecheg97@gmail.com", "nicoelicecheg97@hotmail.com", subject, message);
		return "newAlert";
	}
	
}
