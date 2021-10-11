package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Favorite;
import com.model.FavoriteRequest;
import com.service.FavoriteService;

@RestController
public class FavoriteController {
	@Autowired
	private FavoriteService service;
	
	
	@PostMapping("/favorites") 
	public String addFavorite(@RequestBody FavoriteRequest request) {
		return service.addFavorite(request);
	}
	
	@GetMapping("/favorites/{userEmail}")
	public List<Favorite> getUserFavorites(@PathVariable String userEmail){
		return service.getUserFavorites(userEmail);
	}


}
