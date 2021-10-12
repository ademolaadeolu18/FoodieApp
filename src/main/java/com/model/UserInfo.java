package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class UserInfo {
	private String email;
	private String imageUrl;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public UserInfo(String email, String imageUrl) {
		super();
		this.imageUrl = imageUrl;
		this.email = email;
	}

//	public UserInfo(String responseMessage) {
//		super();
//	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
