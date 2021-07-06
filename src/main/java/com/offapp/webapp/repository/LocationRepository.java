package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
