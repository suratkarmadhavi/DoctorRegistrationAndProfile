package com.oneHealth.DoctorRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.DoctorRegistration.model.DoctorProfile;

/**
 * The ProfileRepository interface extends JpaRepository to provide data access operations for DoctorProfile entity.
 * JpaRepository provides ready-to-use CRUD (Create, Read, Update, Delete) operations for the entity.
 * The entity managed by this repository is DoctorProfile with its primary key of type Long.
 * @author Anup
 * @version 3.9.10
 */
public interface ProfileRepository extends JpaRepository<DoctorProfile, Long> {
	List<DoctorProfile> findByCityAndSpecializations_Name(String city, String specializationName);
	List<DoctorProfile> findBySpecializations_Name(String specializationName);
}
