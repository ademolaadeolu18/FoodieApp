package com.repository;

import java.util.List;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository <Favorite, Long>{
	Favorite findByUser(User user);
}
