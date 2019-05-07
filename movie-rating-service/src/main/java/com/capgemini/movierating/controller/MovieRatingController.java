package com.capgemini.movierating.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.movierating.entity.Rating;
import com.capgemini.movierating.entity.UserRating;

@RestController
@RequestMapping("/ratings")
public class MovieRatingController {
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello";
	}
	
	private List<Rating> ratings;
	
	//HardCode for 1 user
	public MovieRatingController() {
		ratings = new ArrayList<Rating>();
		ratings.add(new Rating(101,3.5));
		ratings.add(new Rating(102,4.5));
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserRating> getUserRatings(@PathVariable String userId){
		
		UserRating userRating = new UserRating();
		System.out.println(userId);	
		
		if(userId.equals("akash")) {
			userRating.setUserRatings(ratings);
			return new ResponseEntity<UserRating>(userRating, HttpStatus.OK);
		}
	return new ResponseEntity<UserRating>(HttpStatus.NOT_FOUND);
	}
	
}
