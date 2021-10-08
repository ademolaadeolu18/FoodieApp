package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="dishes")
public class Dishes {
	@Id
	private String restaurantname;
	private String dishname;
	private int dishprice;
	

}
