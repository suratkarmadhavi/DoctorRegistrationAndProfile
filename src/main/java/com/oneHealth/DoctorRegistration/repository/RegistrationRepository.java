package com.oneHealth.DoctorRegistration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.DoctorRegistration.model.DoctorRegistration;
/**
 * The Registration Repository interface extends JpaRepository to provide data access operations for DoctorRegistration entity.
 * JpaRepository provides ready-to-use CRUD (Create, Read, Update, Delete) operations for the entity.
 * The entity managed by this repository is DoctorRegistration with its primary key of type Long.
 * @author Madhavi
 * @version 3.9.10
 */
public interface RegistrationRepository extends JpaRepository<DoctorRegistration, Long> {
	Optional<DoctorRegistration> findByEmail(String email);
}
