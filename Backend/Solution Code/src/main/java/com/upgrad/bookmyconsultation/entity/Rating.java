package com.upgrad.bookmyconsultation.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;



@Entity
@Data
@NoArgsConstructor
//mark this class as an 'entity class'
//Use Data annotation to generate boilerplate code
//Use NoArgsConstructor annotation
//create a class name Rating
public class Rating {
	//create a primary key called 'id' of type String
    //Set access modifiers for all these members to 'private'
    //initialise id with a UUID using UUID.randomUUID
    @Id
    private String id = String.valueOf(UUID.randomUUID());
	//create appointmentId of type String
    private String appointmentId;
	//create doctorId of type String
    private String doctorId;
	//create rating of type Integer
    private Integer rating;
	//create comments of type String
    private String comments;

}
	
