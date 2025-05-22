package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entities.User;
import com.repositories.UserRepositoriesInt;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserRepositoriesInt userRepositoriesInt;

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
		User user = userRepositoriesInt.findById(userId).orElseThrow();
//		http://localhost:7003/ratings/users/bd5b5b1f-b723-4787-a7b1-ab31082194a6
		ArrayList forObject = restTemplate.getForObject(
				"http://localhost:7003/ratings/users/bd5b5b1f-b723-4787-a7b1-ab31082194a6", ArrayList.class);
		logger.info("{}", forObject);
		return user;

	}

}
