package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.RestaurantDto;
import com.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import com.model.Favorite;
import com.model.Restaurant;
import com.model.User;
import com.repository.FavoriteRepository;
import com.repository.UserRepository;

@Service
public class FavoriteService {

	private FavoriteRepository repository;
	private UserRepository userRepository;
	private RestaurantRepository restaurantRepository;

    public FavoriteService(FavoriteRepository repository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
    	this.repository = repository;
    	this.userRepository = userRepository;
    	this.restaurantRepository = restaurantRepository;
    }
	public String addFavorite(List<Restaurant> restaurants, String email) {
		Optional<User> user = userRepository.findByEmail(email);

		if(user.isPresent()){

			Favorite savedFavorite = repository.findByUser(user.get());
			if(savedFavorite == null) {
				repository.save(Favorite.builder()
						.user(user.get())
						.build());
			}

			restaurants.forEach(restaurant -> {
				restaurant.setFavorite(savedFavorite);
			});
			restaurantRepository.saveAll(restaurants);

			return "Favorite Added Successfully";
		}

		return "Operation Failed";
	}

	public List<RestaurantDto>  getUserFavorites(String userEmail) {
		Optional<User> user = userRepository.findByEmail(userEmail);
		if (user.isPresent()) {
			Favorite favorite = repository.findByUser(user.get());
			List<Restaurant> restaurants = restaurantRepository.findAllByFavorite(favorite);
			List<RestaurantDto> restaurantDtos = new ArrayList<>();
			restaurants.forEach(restaurant -> {
				restaurantDtos.add(
						RestaurantDto.builder()
						.id(restaurant.getId())
						.city(restaurant.getCity())
						.name(restaurant.getName())
						.build());
			});
			return restaurantDtos;
		}
		return null;
	}

}
