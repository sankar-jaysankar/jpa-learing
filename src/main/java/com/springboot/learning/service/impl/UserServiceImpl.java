package com.springboot.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.learning.model.User;
import com.springboot.learning.repository.UserRepository;
import com.springboot.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public List<User> getUserProfile() {
		
		return userRepository.findAll();
	}
	@Override
	public User getParticulerUser(Integer userId) {
		
		return userRepository.findById(userId).get();
	}
	@Override
	public User getParticulerUserByFirstName(String name) {
		
		return userRepository.findByFirstName(name);
	}
	@Override
	public User addNewUser(User user) {
		
		return userRepository.save(user);
	}
	@Override
	public User editUser(User user, Integer userId) {
		user.setUserId(userId);
		return userRepository.save(user);
	}
	@Override
	public Boolean deleteUser(Integer userId) {

		Optional<User> savedUser = userRepository.findById(userId);
		System.out.println(">>>>>>>>>savedUser= "+savedUser);
		if(!savedUser.isEmpty()) {
			userRepository.deleteById(userId);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
}
