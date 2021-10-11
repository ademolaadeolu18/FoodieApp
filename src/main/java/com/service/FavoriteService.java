package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.model.Favorite;
import com.model.FavoriteRequest;
import com.model.Restaurant;
import com.model.User;
import com.repository.FavoriteRepository;
import com.repository.UserRepository;

@Service
public class FavoriteService {

	FavoriteRepository repository;
	UserRepository userRepository;

	public String addFavorite(FavoriteRequest request) {
		Optional<User> user = userRepository.findByEmail(request.getEmail());
		List<Restaurant> restaurants = new ArrayList<>();
		request.getFavorites().forEach(name -> {
			restaurants.add(new Restaurant(name));
		});

		Favorite favorite = new Favorite(user.get().getId(), restaurants);
		repository.save(favorite);
		return favorite.getId() > 0 ? "Favorite Added Successfully" : "Operation Failed";
	}

	public List<Favorite> getUserFavorites(String userEmail) {
		Optional<User> user = userRepository.findByEmail(userEmail);
		if (user.isPresent()) {
			return repository.findByUserId(user.get().getId());
		}
		return null;
	}

}
