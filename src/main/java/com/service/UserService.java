package com.service;

import java.io.IOException;
import java.util.Optional;

import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired()
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	UploadImageService uploadImageService;

	public UserService(UserRepository userRepository, UploadImageService uploadImageService) {
		this.userRepository = userRepository;
		this.uploadImageService = uploadImageService;

	}

	public boolean isExist(String email) {
		Optional<User> op = userRepository.findByEmail(email);
		if (op.isPresent()) {
			return true;
		}
		return false;
	}
	
	public Optional<User> findUserByEmail(String email){
		return userRepository.findByEmail(email);
	}

	public String registerUser(UserRequest request) {
		User user = new User(request.getEmail(), request.getPassword(), null);
		if (isExist(user.getEmail())) {
			return "user already exists";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		try {
			if (request.getFile() != null) {
				String url = uploadImageService.uploadFile(request.getEmail(), request.getFile());
				user.setImageurl(url);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "not successful";
		}
		userRepository.save(user);
		return "added successfully";
	}

	public UserInfo getUserInfo(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent()){
			return new UserInfo(user.get().getEmail(), user.get().getImageurl());
		} else {
			return new UserInfo("","");
		}
	}
}
