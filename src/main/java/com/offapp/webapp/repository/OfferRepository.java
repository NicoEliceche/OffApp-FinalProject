package com.offapp.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	List<Offer> findByTypeIgnoreCase(String type);
	
	Offer findOfferById(Long id);
	
	@Query("FROM Offer o WHERE ((o.description like '%:matcher%' OR o.description is null))")
	List<Offer> findAllByMatchers(@Param("matcher") String matcher);
	
}
