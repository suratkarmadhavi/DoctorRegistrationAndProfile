package com.oneHealth.DoctorRegistration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.DoctorRegistration.model.DoctorRegistration;

public interface RegistrationRepository extends JpaRepository<DoctorRegistration, Long> {
	Optional<DoctorRegistration> findByEmail(String email);
}
