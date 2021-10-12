package com.controller;

import com.model.*;
import com.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class FavoriteController {
	@Autowired
	private FavoriteService service;
	
	
	@PostMapping("/favorites") 
	public String addFavorite(@RequestBody FavoriteRequest favoriteRequest, Principal principal) {
		return service.addFavorite(favoriteRequest.getRestaurants(), principal.getName());
	}
	
	@GetMapping("/favorites")
	public List<RestaurantDto>  getUserFavorites(Principal principal){
		return service.getUserFavorites(principal.getName());
	}




}
