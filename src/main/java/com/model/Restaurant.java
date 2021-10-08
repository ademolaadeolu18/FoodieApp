package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	private String restaurantname;
	private String type;
	private String city;
	private Dishes dish;
	private String contactdetails;
	

}
