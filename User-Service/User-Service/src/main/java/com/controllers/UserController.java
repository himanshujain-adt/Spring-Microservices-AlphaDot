package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.User;
import com.services.UserServiceInt;

import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceInt userServiceInt;

	// create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userServiceInt.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User user = userServiceInt.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userServiceInt.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
