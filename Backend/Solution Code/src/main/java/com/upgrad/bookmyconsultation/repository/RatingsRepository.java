package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//mark it as repository
@Repository
//create an interface RatingsRepository that extends CrudRepository
public interface RatingsRepository extends CrudRepository <Rating, String> {

    //create a method findByDoctorId that returns a list of type Rating
    //define method parameter doctorId of type String

    List<Rating> findByDoctorId(String doctorId);

}