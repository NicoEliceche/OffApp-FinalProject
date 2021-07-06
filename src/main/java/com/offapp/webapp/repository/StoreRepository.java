package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
