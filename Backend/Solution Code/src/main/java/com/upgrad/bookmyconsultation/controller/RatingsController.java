package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	@Autowired
	private RatingsService ratingsService;

	//create a post method named submitRatings with return type as ResponseEntity
	@PostMapping
	//define the method parameter rating of type Rating, use @RequestBody for mapping
	public ResponseEntity submitRatings(@RequestBody Rating rating) {
		//submit the ratings
		ratingsService.submitRatings(rating);
		//return http response with status set to OK
		return new ResponseEntity(HttpStatus.OK);
	}
	
}