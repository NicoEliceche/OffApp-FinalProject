package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.offapp.webapp.model.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
