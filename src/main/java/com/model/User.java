package com.model;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private String email;
	private String password;
	private  URL   imageurl;
	public User(String email, String password, URL imageurl) {
		super();
		this.email = email;
		this.password = password;
		this.imageurl = imageurl;
	}
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
	public URL getImageurl() {
		return imageurl;
	}
	public void setImageurl(URL imageurl) {
		this.imageurl = imageurl;
	}
	

}
