package com.offapp.webapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private Integer top;
	private String author;
	private String description;
	private Double offPrice;
	private Double origPrice;
	private String image;
	private String search;
	private Boolean deleted = false;
	
}
