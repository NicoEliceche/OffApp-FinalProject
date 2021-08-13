package com.offapp.webapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.offapp.webapp.model.Offer;
import com.offapp.webapp.model.Store;
import com.offapp.webapp.repository.StoreRepository;
import com.offapp.webapp.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {

	private StoreService storeService;
	private StoreRepository storeRepository;
	
	@Autowired
	public StoreController(StoreService storeService, StoreRepository storeRepository) {
		this.storeService = storeService;
		this.storeRepository = storeRepository;
	}
	
	// REDIRECT TO NEW STORE FORM
	@RequestMapping (value = "/new", method = RequestMethod.GET)
	public String newStore(Model model) {
		model.addAttribute("store", new Store());
		return "newStore";
	}
		
	// CREATE STORE
	@PostMapping(value = "/create")
	public String createOffer(@RequestParam(value = "image") String image,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "address") String address, 
			@RequestParam(value = "contact") String contact, Model model) {

		Store store = new Store();
		store.setImage(image);
		store.setName(name);
		store.setAddress(address);
		store.setContact(contact);

		store = storeService.save(store);
		
		model.addAttribute("store", store);
		System.out.println(String.format("Se creó el negocio con id: %s", store.getId()));
		return "redirect:/store/new";
	}
	
	// UPDATE STORE
	@RequestMapping (value = "/update/{id}", method = RequestMethod.GET)
	public String updateStore(@PathVariable(name = "id", required = true) Long id, Model model) {
		Optional<Store> storeOp = storeRepository.findById(id);
		if (!storeOp.isPresent())
			return "redirect:error";
		
		model.addAttribute("store", storeOp.get());
		return "updateStore";
	}
	
	// SAVE STORE
	@PostMapping("/save")
	public String saveStore(@Validated Store store, Model model) {
		storeService.save(store);
		return "redirect:/friend_businesses";
	}	
		
	// DELETE STORE
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String deleteStore(@PathVariable(value = "id") Long id, Model model) {
		storeService.deleteStoreById(id);
		return "redirect:/";
	}
}
