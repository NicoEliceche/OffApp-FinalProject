package com.offapp.webapp.model;

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
public class Location {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double lat;
	private double len;

	private String string;

	public String getLocation(String name) {		
		StringBuilder sb = new StringBuilder();
		sb.append("Latitude: " + lat + "\n");
		sb.append("Length: " + len);
		return sb.toString();
	}
}
