package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Doctor;
import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.repository.DoctorRepository;
import com.upgrad.bookmyconsultation.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class RatingsService {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private RatingsRepository ratingsRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	
	//create a method name submitRatings with void return type and parameter of type Rating
	public void submitRatings(Rating rating){
		//set a UUID for the rating
		UUID uuid = UUID.randomUUID();
		rating.setId(String.valueOf(uuid));
		//save the rating to the database
		ratingsRepository.save(rating);

		//get the doctor id from the rating object
		Doctor doctor = doctorRepository.findById(rating.getDoctorId()).get();
		//find that specific doctor with the using doctor id
		Double averageRating =
				ratingsRepository.findByDoctorId(rating.getDoctorId()).stream().collect(Collectors.averagingInt(Rating::getRating));
		//modify the average rating for that specific doctor by including the new rating
		//save the doctor object to the database
		doctor.setRating(averageRating);
		doctorRepository.save(doctor);
	}
}
