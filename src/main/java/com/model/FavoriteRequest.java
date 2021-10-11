package com.model;

import java.util.List;

public class FavoriteRequest {
	private List<String> favorites;
	private String email;
	
	
	public FavoriteRequest(List<String> favorites, String email) {
		super();
		this.favorites = favorites;
		this.email = email;
	}
	
	public List<String> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
