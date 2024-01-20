package com.springboot.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.learning.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByFirstName(String name);

}
