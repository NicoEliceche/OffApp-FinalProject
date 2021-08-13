package com.offapp.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offapp.webapp.model.Offer;
import com.offapp.webapp.model.Store;
import com.offapp.webapp.repository.StoreRepository;

@Service
public class StoreService {

	private StoreRepository storeRepository;
	
	@Autowired
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}
	 // SAVE STORE
	public Store save(Store store) {
		return storeRepository.saveAndFlush(store);
	}
	
	// LIST STORE
	public List<Store> listStores() {
		return storeRepository.findAll();
	}
	
	// UPDATE STORE
		public Optional<Store> getId(Long id) {
			return storeRepository.findById(id);
		}
	
	// DELETE STORE
	public void deleteStoreById(Long id) {
		storeRepository.deleteById(id);
	}
}
