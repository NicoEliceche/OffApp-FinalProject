package com.offapp.webapp.model;

import java.util.ArrayList;
import java.util.Iterator;
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
public class Store{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String contact;
	private String image;
	private Integer lat;
	private Integer len;
	
	@OneToMany
	List<Category> category = new ArrayList<Category>();
	
	@OneToMany
	List<Offer> offer = new ArrayList<Offer>();

//	public String getAddress() {		
//		StringBuilder sb = new StringBuilder();
//		sb.append("Latitude: " + this.getLat() + "\n");
//		sb.append("Length: " + this.getLen());
//		this.address = sb.toString();
//		return address;
//	}
	
//	public void setAddress(Integer lat, Integer len) {
//		this.lat = lat;
//		this.len = len;
//		System.out.println("Se ha establecido la ubicación para: " + this.getName());
//	}
	
}
