package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.config.UploadImageService;

import com.model.LoginRequest;
import com.model.LoginResponse;
import com.model.User;
import com.model.UserRequest;
import com.repository.UserRepository;

@Service
public class UserService {

	private UserRepository repo;
	
	@Autowired(required = false)
	private BCryptPasswordEncoder passwordEncoder;
//	@Autowired
	UploadImageService uploadImageService;

	public UserService(UserRepository repo, UploadImageService uploadImageService) {
		this.repo = repo;
		this.uploadImageService = uploadImageService;

	}

	public boolean isExist(String email) {
		Optional<User> op = repo.findByEmail(email);
		if (op.isPresent()) {
			return true;
		}
		return false;
	}
	
	public Optional<User> findUserByEmail(String email){
		return repo.findByEmail(email);
	}

	public String registerUser(UserRequest request) {
		User user = new User(request.getEmail(), request.getPassword(), null);
		if (isExist(user.getEmail())) {
			return "user already exists";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		try {
			if (request.getFile() != null) {
				String url = uploadImageService.uploadFile(request.getEmail(), request.getFile());
				user.setImageurl(url);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "not successful";
		}
		repo.save(user);
		return "added successfully";
	}

	public LoginResponse userValidation(LoginRequest login) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<User> user = repo.findByEmail(login.getEmail());
		if (passwordEncoder.matches(login.getPassword(), user.get().getPassword())) {
			return new LoginResponse(user.get().getEmail(), user.get().getImageurl(), "Login Successful");
		}
		return new LoginResponse("", "", "Login Failed");
	}
}
