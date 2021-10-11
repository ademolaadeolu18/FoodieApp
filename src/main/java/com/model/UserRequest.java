package com.model;

import org.springframework.web.multipart.MultipartFile;

public class UserRequest {
	private String email;
	private String password;
	private MultipartFile file;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public UserRequest(String email, String password, MultipartFile file) {
		super();
		this.email = email;
		this.password = password;
		this.file = file;
	}
	public UserRequest() {
		super();
	}	

}
