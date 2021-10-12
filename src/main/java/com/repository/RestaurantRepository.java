package com.repository;

import com.model.Favorite;
import com.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository <Restaurant, Long>{
    List<Restaurant> findAllByFavorite(Favorite favorite);
}
