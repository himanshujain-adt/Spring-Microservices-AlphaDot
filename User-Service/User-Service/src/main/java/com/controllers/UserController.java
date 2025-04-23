package com.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.User;
import com.services.UserServiceInt;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserServiceInt userServiceInt;
	
	//create
	@PostMapping
	public 	ResponseEntity<User> createUser(@RequestBody User user){
		User user1=userServiceInt.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

}
