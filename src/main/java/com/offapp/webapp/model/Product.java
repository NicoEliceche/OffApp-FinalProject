package com.offapp.webapp.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue ("PRODUCT")
@Getter
@Setter
@NoArgsConstructor
public class Product extends Type implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String TIPO = "Product";
	


}
