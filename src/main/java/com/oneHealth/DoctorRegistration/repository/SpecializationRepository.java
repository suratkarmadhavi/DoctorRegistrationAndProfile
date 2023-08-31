package com.oneHealth.DoctorRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.DoctorRegistration.model.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

}
