package com.oneHealth.DoctorRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oneHealth.DoctorRegistration.model.Specialization;

/**
 * Repository interface for accessing and managing Doctor Specialization entities in the database.
 * This interface extends JpaRepository, providing CRUD (Create, Read, Update, Delete) operations
 * for Doctor Specialization entities.
 * 
 * @author Anup
 * @version 1.0
 */
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    // This interface inherits standard JpaRepository methods for database operations.
    // You can also define custom query methods if needed.
}
