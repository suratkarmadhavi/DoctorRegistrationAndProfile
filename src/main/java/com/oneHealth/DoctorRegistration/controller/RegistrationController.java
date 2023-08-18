package com.oneHealth.DoctorRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorRegistration;
import com.oneHealth.DoctorRegistration.service.RegistrationService;

import jakarta.validation.Valid;

/**
 * This controller class is responsible for managing APIs related to the registration process.
 * It handles HTTP requests for saving , retrieving , updating and deleting doctor registration details.
 * @author Anup
 * @version 3.9.10
 */
@RestController
@RequestMapping("/api/doctors/addressprofileregistration")
public class RegistrationController 
{
	@Autowired
	private RegistrationService service;
	
	
	
	
	
	/**
     * Endpoint to save the registration details of a doctor.
     * @param reg The DoctorRegistration object containing the details of the doctor to be registered.
     * @return A ResponseEntity with a success message and HTTP status CREATED (201) on successful registration.
     */
	@PostMapping("/registration")
	public ResponseEntity<String> saveProfile(@Valid @RequestBody DoctorRegistration reg  ) throws DatabaseException
	{
		service.saveRegistrationDetails(reg);
		return new ResponseEntity<>("Registration Details Saved Successfully", HttpStatus.CREATED);
	}
	
	
	
	
	
	/**
     * Endpoint to retrieve the registration details of a doctor by their profile ID.
     *
     * @param profile_id The profile ID of the doctor to be retrieved.
     * @return A ResponseEntity with the DoctorRegistration object containing the details of the doctor
     *         and HTTP status OK (200) on successful retrieval.
     * @throws ProfileNotFoundException If the profile ID does not match any registered doctor.
     */
	@GetMapping("/getdoctor/{id}")
	public ResponseEntity<DoctorRegistration> getProfileByID(@PathVariable(value="id") Long profile_id) throws ProfileNotFoundException
	{
		DoctorRegistration obj = service.findProfileByID(profile_id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	
	/**
	 * Retrieves a list of all registered doctors.
	 *
	 * @return A ResponseEntity containing a list of DoctorRegistration objects with HTTP status 200 (OK) if successful.
	 *         If a DatabaseException occurs during the process, it will return a ResponseEntity with an error message
	 *         and HTTP status 500 (Internal Server Error).
	 *
	 * @throws DatabaseException If there is an error while fetching doctors from the database.
	 */
	@GetMapping("/getalldoctors")
	public ResponseEntity<List<DoctorRegistration>> getAllDoctors() throws DatabaseException
	{
		// Retrieve the list of all registered doctors from the service layer.
	        List<DoctorRegistration> doctors = service.getAllDoctors();
	        
	     // Return the list of doctors in the response with HTTP status 200 (OK).
	        return new ResponseEntity<>(doctors, HttpStatus.OK);
	     
	}
	
	
	
	
	
	
	/**
	 * Updates the status of a doctor's registration identified by the given profile ID.
	 *
	 * @param profile_id The profile ID of the doctor whose status needs to be updated.
	 * @param reg        The DoctorRegistration object containing the updated status.
	 * @return A ResponseEntity with a success message and HTTP status code 201 (CREATED) upon successful update.
	 * @throws ProfileNotFoundException If no doctor's registration is found with the given profile ID.
	 */
	@PutMapping("/updatestatus/{id}")
	public ResponseEntity<String> updateStatus(@PathVariable(value="id") long profile_id , @RequestBody DoctorRegistration reg) throws ProfileNotFoundException
	{
		service.updateDoctorStatus(profile_id, reg);
		return new ResponseEntity<>("Doctor Status Updated Successfully", HttpStatus.CREATED);
	}
	
	
	
	
}
