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
public class Store {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String address;
	private String contact;
	private Boolean enabled;
	
	@OneToMany
	List<Category> category = new ArrayList<Category>();
	
	@OneToMany
	List<Store> stores = new ArrayList<Store>();
	
	@OneToMany
	List<Location> location = new ArrayList<Location>();

//	public Object addLocation (int x, int y) {
//		int [][] businessLoc = new int [1][1];
//		for (int i = 0; i < businessLoc.length; i++) {
//			for (int j = 0; j < businessLoc.length; j++) {
//				businessLoc[j] = y;
//			}
//		}
//		return null;
//	}
}
