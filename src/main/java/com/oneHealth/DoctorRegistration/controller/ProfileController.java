package com.oneHealth.DoctorRegistration.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneHealth.DoctorRegistration.DTO.DocumentsDTO;
import com.oneHealth.DoctorRegistration.DTO.UpdateSpecializationsRequest;
import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorProfile;
import com.oneHealth.DoctorRegistration.model.Specialization;
import com.oneHealth.DoctorRegistration.service.ProfileService;

import jakarta.validation.Valid;

/**
 * The ProfileController class is a REST controller that handles HTTP requests related to doctor profiles.
 * It provides endpoints for managing doctor profile information.
 * 
 * @author Anup
 * @version 3.9.10
 */
@RestController
@RequestMapping("/api/doctors/addressprofileregistration")
public class ProfileController {
    
    private static final Logger LOGGER = Logger.getLogger(ProfileController.class.getName());

    @Autowired
    private ProfileService service;

    /**
     * Handles HTTP POST request to save the doctor profile information into the database.
     *
     * @param profile The DoctorProfile object containing the doctor's profile details.
     * @return A ResponseEntity with the response message and HTTP status code.
     * @throws DatabaseException If there is an issue while interacting with the database.
     */
    @PostMapping("/saveprofile")
    public ResponseEntity<String> saveDoctorProfile(@Valid @RequestBody DoctorProfile profile) {
        LOGGER.info("In Controller - Saving doctor profile: " + profile);
        try {
            service.SaveDoctorProfile(profile);
            return new ResponseEntity<>("Doctor Profile Saved Successfully", HttpStatus.CREATED);
        } catch (DatabaseException e) {
            LOGGER.info("Error while saving doctor profile: " + e.getMessage());
            return new ResponseEntity<>("Failed to save doctor profile", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Retrieves a specific doctor profile from the database based on the provided doctor_id.
     *
     * @param doctor_id The ID of the doctor profile to retrieve.
     * @return ResponseEntity containing the DoctorProfile object with the specified ID and HTTP status code 200 (OK).
     * @throws ProfileNotFoundException If no doctor profile is found with the given ID.
     */
    @GetMapping("/getdoctorprofile/{id}")
    public ResponseEntity<DoctorProfile> getProfileByID(@PathVariable(value="id") Long doctor_id) {
        LOGGER.info("In Controller - Retrieving doctor profile for ID: " + doctor_id);
        try {
            DoctorProfile obj = service.getProfileByID(doctor_id);
            return ResponseEntity.ok().body(obj);
        } catch (ProfileNotFoundException e) {
            LOGGER.info("Profile not found for ID: " + doctor_id);
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Retrieves the list of all doctors' profiles from the database.
     *
     * @return A ResponseEntity with the list of DoctorProfile objects in the response body and HTTP status code 200 (OK).
     * @throws DatabaseException If an error occurs while retrieving the data from the database.
     */
    @GetMapping("/getalldoctorsprofile")
    public ResponseEntity<List<DoctorProfile>> getAllDoctorsProfile() {
        LOGGER.info("In Controller - Retrieving profiles of all doctors");
        try {
            List<DoctorProfile> doctorsprofile = service.getAllDoctorsProfile();
            return ResponseEntity.ok(doctorsprofile);
        } catch (DatabaseException e) {
            LOGGER.info("Error while retrieving all doctors' profiles: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    /**
     * Updates the profile of a doctor identified by the given doctor_id.
     *
     * @param doctor_id The doctor_id of the doctor whose profile needs to be updated.
     * @param profile   The updated DoctorProfile object.
     * @return A ResponseEntity with a success message and HTTP status code 200 (OK) upon successful update.
     * @throws ProfileNotFoundException If no doctor's profile is found with the given doctor_id.
     */
    @PutMapping("/updateprofile/{id}")
    public ResponseEntity<String> updateDoctorProfile(@PathVariable(value="id") Long doctor_id , @RequestBody DoctorProfile profile) {
        LOGGER.info("In Controller - Updating doctor profile for ID: " + doctor_id);
        try {
            service.updateProfile(doctor_id, profile);
            return new ResponseEntity<>("Profile Updated Successfully", HttpStatus.OK);
        } catch (ProfileNotFoundException e) {
            LOGGER.info("Profile not found for ID: " + doctor_id);
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Handles the HTTP DELETE request to delete a doctor's profile by ID.
     *
     * @param doctor_id The ID of the doctor's profile to be deleted.
     * @return A ResponseEntity with a custom success message and HTTP status 200 (OK) upon successful deletion.
     * @throws ProfileNotFoundException If no profile is found with the given doctor_id.
     */
    @DeleteMapping("/deletedoctorprofile/{id}")
    public ResponseEntity<String> deleteDoctorProfile(@PathVariable(value="id") Long doctor_id) throws ProfileNotFoundException
    {
        LOGGER.info("In Controller - Deleting doctor profile for ID: " + doctor_id);
        service.deleteDoctorProfile(doctor_id);
        return new ResponseEntity<>("Doctor Profile deleted Successfully" , HttpStatus.OK);
    }
    
    
    @GetMapping("/by-city-and-specialization")
    public List<DoctorProfile> getDoctorsByCityAndSpecialization(
            @RequestParam String city,
            @RequestParam String specialization) {
        return service.getDoctorsByCityAndSpecialization(city, specialization);
    }
    
    
    @GetMapping("/by-specialization")
    public List<DoctorProfile> getDoctorsBySpecialization(@RequestParam String specialization)
    {

        return service.getDoctorsBySpecialization(specialization);

    }
    
    
    @PutMapping("/{doctor_id}/update-documents")
    public ResponseEntity<String> updateDoctorProfile(
            @PathVariable Long doctor_id, @RequestBody DocumentsDTO request) {
        boolean updated = service.updateDocuments(doctor_id, request);
        
        if (updated) {
            return ResponseEntity.ok("Doctor profile updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PutMapping("/{specId}/update-specializations")
    public ResponseEntity<String> updateSpecializationName(
            @PathVariable Long specId, @RequestBody Specialization request) {
        boolean updated = service.updateSpecializationName(specId, request.getName());
        
        if (updated) {
            return ResponseEntity.ok("Specialization name updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @DeleteMapping("/{doctorId}/remove-specialization/{specializationId}")
    public ResponseEntity<String> removeSpecializationFromDoctor(
            @PathVariable Long doctorId, @PathVariable Long specializationId) {
        boolean removed = service.removeSpecializationFromDoctor(doctorId, specializationId);
        
        if (removed) {
            return ResponseEntity.ok("Specialization removed from doctor successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/IsDoctorAvailable/{doctor_id}")
    public boolean checkIsDoctorAvailable(@PathVariable long doctor_id)
    {
    	return service.checkIsDoctorAvailable(doctor_id);
    }
}
