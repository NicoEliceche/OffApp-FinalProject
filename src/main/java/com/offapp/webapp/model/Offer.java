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

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Offer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String author;
	private String authorFirst;
	private String authorSecond1;
	private String authorSecond2;
	private String authorThird1;
	private String authorThird2;
	private String authorThird3;
	private String description;
	private String descriptionFirst;
	private String descriptionSecond1;
	private String descriptionSecond2;
	private String descriptionThird1;
	private String descriptionThird2;
	private String descriptionThird3;
	private Double offPrice;
	private Double offPriceFirst;
	private Double offPriceSecond1;
	private Double offPriceSecond2;
	private Double offPriceThird1;
	private Double offPriceThird2;
	private Double offPriceThird3;
	private Double origPrice;
	private Double origPriceFirst;
	private Double origPriceSecond1;
	private Double origPriceSecond2;
	private Double origPriceThird1;
	private Double origPriceThird2;
	private Double origPriceThird3;
	private Boolean enabled = Boolean.TRUE;
	private Blob image;
	private Blob imageFirst;
	private Blob imageSecond1;
	private Blob imageSecond2;
	private Blob imageThird1;
	private Blob imageThird2;
	private Blob imageThird3;
	
}
