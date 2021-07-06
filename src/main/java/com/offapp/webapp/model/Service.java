package com.offapp.webapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue ("SERVICE")
@Getter
@Setter
@NoArgsConstructor
public class Service extends Type {

	private static final long serialVersionUID = 1L;
	private static final String TIPO = "Service";

	private String name;
}
