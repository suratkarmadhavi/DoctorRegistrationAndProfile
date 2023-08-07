package com.oneHealth.DoctorRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.DoctorRegistration.model.DoctorAddress;


/**
 * The DoctorAddressRepository interface extends JpaRepository to perform CRUD operations on DoctorAddress entity.
 * 
 * This repository provides the necessary methods to interact with the database and manage doctor address data.
 * It inherits basic CRUD operations from JpaRepository and supports additional custom queries if needed.
 * 
 * Note: Make sure to import the required entities and annotations from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1.0
 */
public interface DoctorAddressRepository extends JpaRepository<DoctorAddress, Long> {
	
	List<DoctorAddress> findByDoctorId(long doctorId);
 
}
