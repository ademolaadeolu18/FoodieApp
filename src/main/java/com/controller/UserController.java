package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.LoginRequest;
import com.model.LoginResponse;
import com.model.User;
import com.model.UserRequest;
import com.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@CrossOrigin
	@PostMapping(value = "/register")
	public String register(@RequestParam MultipartFile file, @RequestParam String email,
			@RequestParam String password) {
		 UserRequest request = new UserRequest(email, password, file);
		return service.registerUser(request);

	}

	@PostMapping(value ="/login")
	public LoginResponse login(@RequestBody LoginRequest login) {
		return service.userValidation(login);
	}

}
