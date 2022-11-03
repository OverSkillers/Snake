package com.example.snakeladder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.snakeladder.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}