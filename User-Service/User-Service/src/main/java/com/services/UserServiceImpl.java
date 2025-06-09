package com.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entities.Hotel;
import com.entities.Rating;
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

//	@Override
//	public User getUser(String userId) {
//		// TODO Auto-generated method stub
//		User user = userRepositoriesInt.findById(userId).orElseThrow();
////		http://localhost:7003/ratings/users/bd5b5b1f-b723-4787-a7b1-ab31082194a6
//		ArrayList<Rating> ratingsoFUser = restTemplate.getForObject(
//				"http://localhost:7003/ratings/users/"+user.getUserId(), ArrayList.class);
//		logger.info("{}", ratingsoFUser);
//		
//		List<Rating> ratingList=(List<Rating>) ratingsoFUser.stream().map(rating->{
//			// http://localhost:7003/ratings/hotels/d598cf32-7fa7-4b6a-a8f8-e26c8891f433
//			ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://localhost:7003/ratings/hotels/"+rating.getHotelId(), Hotel.class);
//		Hotel hotel=	forEntity.getBody();
//		logger.info("response status code {}",forEntity.getStatusCode());
//		rating.setHotel(hotel);
//			return rating;
//		}).collect(Collectors.toList());
//		//user.setRatings(ratingsoFUser);
//		user.setRatings(ratingList);
//		return user;
//
//	}
	
	@Override
	public User getUser(String userId) {
	    User user = userRepositoriesInt.findById(userId).orElseThrow();
	    
	    Rating[] ratingsOfUser = restTemplate.getForObject(
	        "http://localhost:7003/ratings/users/" + user.getUserId(), Rating[].class);
	    
	    List<Rating> ratingList = Arrays.stream(ratingsOfUser).map(rating -> {
	        Hotel[] hotels = restTemplate.getForObject(
	            "http://localhost:7003/ratings/hotels/" + rating.getHotelId(), Hotel[].class);
	        
	      
	        rating.setHotel(hotels[0]);
	        return rating;
	    }).collect(Collectors.toList());
	    
	    user.setRatings(ratingList);
	    return user;
	}

}
