package com.model;

import org.springframework.web.multipart.MultipartFile;

public class LoginResponse {
	private String email;
	private String imageUrl;
	private String responseMessage;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public LoginResponse(String email, String imageUrl, String responseMessage) {
		super();
		this.imageUrl = imageUrl;
		this.responseMessage = responseMessage;
		this.email = email;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public LoginResponse(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
