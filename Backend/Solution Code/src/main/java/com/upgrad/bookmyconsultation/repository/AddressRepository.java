package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//mark it as repository
@Repository
//create an interface AddressRepository that extends CrudRepository
public interface AddressRepository extends CrudRepository <Address, String>{
}

