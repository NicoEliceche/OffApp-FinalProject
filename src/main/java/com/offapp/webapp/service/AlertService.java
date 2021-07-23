package com.offapp.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offapp.webapp.model.Alert;
import com.offapp.webapp.repository.AlertRepository;

@Service
public class AlertService {

	private final AlertRepository alertRepository;
	
	@Autowired
	public AlertService(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}
	
	public Alert save(Alert alert) {
		return alertRepository.saveAndFlush(alert);
	}
	
	public List<Alert> listOffers() {
		return alertRepository.findAll();
	}
}
