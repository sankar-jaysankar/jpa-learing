package com.springboot.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learning.model.User;
import com.springboot.learning.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUserProfile(){
		return userService.getUserProfile();
	}

	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable(value = "userId") Integer userId) {
		return userService.getParticulerUser(userId);
	}

	@GetMapping("/user/name/{name}")
	public User getUserByName(@PathVariable String name) {
		return userService.getParticulerUserByFirstName(name);
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}

	@PutMapping("/user/{userId}")
	public User editUser(@PathVariable Integer userId ,@RequestBody User user) {
		return userService.editUser(user,userId);
	}

	@DeleteMapping("/user/{userId}")
	public Boolean deleteUser(@PathVariable Integer userId){
		return userService.deleteUser(userId);
	}
}
