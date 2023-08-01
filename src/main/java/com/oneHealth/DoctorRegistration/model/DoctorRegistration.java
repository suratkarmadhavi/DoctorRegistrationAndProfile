package com.oneHealth.DoctorRegistration.model;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * This class represents the DoctorRegistration entity used to register doctors in our application.
 * Doctors can be registered with various attributes such as first name, last name, email, contact,
 * license number, specialization, status, and password.
 * @author Anup
 * @version 3.9.10
 */
@Entity
public class DoctorRegistration {

    // Primary key for the entity. The @Id annotation marks this field as the primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Value(value = "101") // Default value for the profile_id. You can remove this if not needed.
    private long profile_id;

    // Fields to store various attributes of the DoctorRegistration entity.
    
    @NotBlank(message = "First name is required")
    private String first_name;

    @NotBlank(message = "Last name is required")
    private String last_name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    @NotBlank(message = "Contact number is required")
    private String contact;

    @NotBlank(message = "License number is required")
    private String license_number;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Status is required")
    private String status;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    @NotBlank(message = "Password is required")
    private String password;

    // Default constructor required by JPA. Should be available for every entity.
    public DoctorRegistration() {
    	

    }

    /**
     * Parameterized constructor to initialize all attributes of the DoctorRegistration entity.
     *
     * @param profile_id      The profile ID of the doctor.
     * @param first_name      The first name of the doctor.
     * @param last_name       The last name of the doctor.
     * @param email           The email address of the doctor.
     * @param contact         The contact number of the doctor.
     * @param license_number  The license number of the doctor.
     * @param specialization  The specialization of the doctor (e.g., Pediatrics, Cardiology, etc.).
     * @param status          The status of the doctor's registration (e.g., Approved, Not Approved).
     * @param password        The password chosen by the doctor for authentication.
     */
    public DoctorRegistration(long profile_id, String first_name, String last_name, String email, String contact,
            String license_number, String specialization, String status, String password) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.contact = contact;
        this.license_number = license_number;
        this.specialization = specialization;
        this.status = status;
        this.password = password;
    }

    /**
     * Getter for the profile ID of the doctor.
     *
     * @return The profile ID of the doctor.
     */
    public long getProfile_id() {
        return profile_id;
    }

    /**
     * Setter for the profile ID of the doctor.
     *
     * @param profile_id The profile ID to set for the doctor.
     */
    public void setProfile_id(long profile_id) {
        this.profile_id = profile_id;
    }

    /**
     * Getter for the first name of the doctor.
     *
     * @return The first name of the doctor.
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Setter for the first name of the doctor.
     *
     * @param first_name The first name to set for the doctor.
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Getter for the last name of the doctor.
     *
     * @return The last name of the doctor.
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Setter for the last name of the doctor.
     *
     * @param last_name The last name to set for the doctor.
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Getter for the email address of the doctor.
     *
     * @return The email address of the doctor.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email address of the doctor.
     *
     * @param email The email address to set for the doctor.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the contact number of the doctor.
     *
     * @return The contact number of the doctor.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Setter for the contact number of the doctor.
     *
     * @param contact The contact number to set for the doctor.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Getter for the license number of the doctor.
     *
     * @return The license number of the doctor.
     */
    public String getLicense_number() {
        return license_number;
    }

    /**
     * Setter for the license number of the doctor.
     *
     * @param license_number The license number to set for the doctor.
     */
    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    /**
     * Getter for the specialization of the doctor.
     *
     * @return The specialization of the doctor.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Setter for the specialization of the doctor.
     *
     * @param specialization The specialization to set for the doctor.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Getter for the status of the doctor's registration.
     *
     * @return The status of the doctor's registration.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter for the status of the doctor's registration.
     *
     * @param status The status to set for the doctor's registration.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for the password chosen by the doctor for authentication.
     *
     * @return The password chosen by the doctor.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the password chosen by the doctor for authentication.
     *
     * @param password The password to set for the doctor.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
