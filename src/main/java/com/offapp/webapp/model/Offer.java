package com.offapp.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Offer implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String OFFER = "Offer";
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private BigDecimal enabled;
	private BigDecimal cost;
	private BigDecimal offPercentage;

	@OneToMany
	List<Offer> offers = new ArrayList<Offer>();
	
}
