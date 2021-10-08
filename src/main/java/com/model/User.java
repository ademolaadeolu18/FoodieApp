package com.model;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String email;
	private String password;
	private  URL   imageurl;
	

}
