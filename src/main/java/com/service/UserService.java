package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.Login;
import com.model.User;
import com.repository.Repository;

@Service
public class UserService {
	
	private Repository repo; 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public boolean findUser(String email) {
		Optional<User> op = repo.findById(email);
		if(op.isPresent()) {
				return true;
			}
		return false;
	}
	
	public String registerUser(User user) {
		if(findUser(user.getEmail())== true) {
			return "user already exists";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		repo.save(user);
		return "added successfully";
	}
	
	public boolean userValidation(Login login) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		List<User> al = repo.findAll();
		for(User user:al) {
			if(login.getEmail().equals(user.getEmail()) && encoder.matches(login.getPassword(), user.getPassword())) {
				return true;
			}
	}
	return false;
	
	}
}
