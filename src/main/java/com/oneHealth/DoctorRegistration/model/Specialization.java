package com.oneHealth.DoctorRegistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a doctor's specialization.
 * This class is used to model a specialization for a doctor and is annotated with JPA annotations
 * to indicate it is a persistent entity.
 * 
 * @author Madhavi
 * @version 1.0
 */
@Entity
public class Specialization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long specId;  // Unique identifier for the specialization.
    
    private String name;  // Name of the specialization.

    /**
     * Default constructor for the Specialization class.
     */
    public Specialization() {
    }

    /**
     * Parameterized constructor for Specialization class to initialize fields.
     *
     * @param specId The unique identifier for the specialization.
     * @param name The name of the specialization.
     */
    public Specialization(long specId, String name) {
        super();
        this.specId = specId;
        this.name = name;
    }

    /**
     * Getter method to retrieve the specialization's unique identifier.
     *
     * @return The unique identifier for the specialization.
     */
    public long getSpecId() {
        return specId;
    }

    /**
     * Setter method to set the specialization's unique identifier.
     *
     * @param specId The unique identifier for the specialization.
     */
    public void setSpecId(long specId) {
        this.specId = specId;
    }

    /**
     * Getter method to retrieve the name of the specialization.
     *
     * @return The name of the specialization.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method to set the name of the specialization.
     *
     * @param name The name of the specialization.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialization [specId=" + specId + ", name=" + name + "]";
    }
}
