package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User;

public interface Repository extends JpaRepository <User, String>{

}
