package com.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.User;
import com.repositories.UserRepositoriesInt;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserRepositoriesInt userRepositoriesInt;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepositoriesInt.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepositoriesInt.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userRepositoriesInt.findById(userId).orElseThrow();
	}

}
