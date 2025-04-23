package com.services;

import java.util.List;

import com.entities.User;

public interface UserServiceInt {
	
	public User saveUser(User user);
	
	public List<User> getAllUser();
	
	public User getUser(String userId);

}
