package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.ResourceUnAvailableException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.repository.AppointmentRepository;
import com.upgrad.bookmyconsultation.repository.UserRepository;
import com.upgrad.bookmyconsultation.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {


	//mark it autowired
	//create an instance of AppointmentRepository called appointmentRepository
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserRepository userRepository;


	//create a method name appointment with the return type of String and parameter of type Appointment
	//declare exceptions 'SlotUnavailableException' and 'InvalidInputException'
	public String appointment(Appointment appointment) throws InvalidInputException, SlotUnavailableException {
		//validate the appointment details using the validate method from ValidationUtils class
		ValidationUtils.validate(appointment);
		//find if an appointment exists with the same doctor for the same date and time
		if (appointmentRepository.findByDoctorIdAndTimeSlotAndAppointmentDate(appointment.getDoctorId(),appointment.getTimeSlot(),appointment.getAppointmentDate()) != null) {
			//if the appointment exists throw the SlotUnavailableException
			throw new SlotUnavailableException();
		} else {
			//save the appointment details to the database
			appointmentRepository.save(appointment);
			//return the appointment id
			return appointment.getAppointmentId();
		}
	}


	//create a method getAppointment of type Appointment with a parameter name appointmentId of type String
	public Appointment getAppointment(String appointmentId) {
		//Use the appointmentid to get the appointment details
		//if the appointment exists return the appointment
			//else throw ResourceUnAvailableException
			//tip: use Optional.ofNullable(). Use orElseThrow() method when Optional.ofNullable() throws NULL
		return Optional.of(appointmentRepository.findById(appointmentId)).get().orElseThrow(ResourceUnAvailableException::new);
		}
	
	public List<Appointment> getAppointmentsForUser(String userId) {
		return appointmentRepository.findByUserId(userId);
	}
}
