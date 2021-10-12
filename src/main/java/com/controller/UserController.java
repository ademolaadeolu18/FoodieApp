package com.controller;

import com.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.model.LoginRequest;
import com.model.UserRequest;
import com.service.UserService;

import java.security.Principal;

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

	@GetMapping(value ="/userInfo")
	public UserInfo login(Principal principal) {
		return service.getUserInfo(principal.getName());
	}

}
