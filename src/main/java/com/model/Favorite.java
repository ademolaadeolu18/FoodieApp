package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "favorite")
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long userId;
	@OneToMany
	private List<Restaurant> restaurantNames;
	public Favorite() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Restaurant> getRestaurantNames() {
		return restaurantNames;
	}
	public void setRestaurantNames(List<Restaurant> restaurantNames) {
		this.restaurantNames = restaurantNames;
	}
	public Favorite(Long userId, List<Restaurant> restaurantNames) {
		super();
		this.userId = userId;
		this.restaurantNames = restaurantNames;
	}
	
	
	

}
