package com.springboot.learning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.learning.model.User;

@Service
public interface UserService {

	List<User> getUserProfile();

	User getParticulerUser(Integer userId);

	User getParticulerUserByFirstName(String name);

	User addNewUser(User user);

	User editUser(User user, Integer userId);

	Boolean deleteUser(Integer userId);


}
