package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository <Favorite, Long>{

	List<Favorite> findByUserId(long userId);
}
