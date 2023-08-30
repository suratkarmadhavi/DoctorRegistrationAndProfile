package com.oneHealth.DoctorRegistration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorAddress;
import com.oneHealth.DoctorRegistration.service.DoctorAddressService;


/**
 * Controller class for handling Doctor Address related HTTP requests.
 * 
 * This class defines methods for saving, retrieving, updating, and deleting doctor addresses.
 * It uses a service class, DoctorAddressService, to perform the actual business logic.
 * The controller maps HTTP endpoints to these methods, allowing clients to interact with the application.
 * Additionally, the class includes logging statements to log important events for monitoring and debugging.
 * 
 * Note: Make sure to import the required entities, exceptions, and services from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1.0
 */
@RestController
@RequestMapping("/api/doctors/addressprofileregistration")
public class DoctorAddressController {

    // Logger for logging important events
    private final Logger logger = LoggerFactory.getLogger(DoctorAddressController.class);

    @Autowired
    private DoctorAddressService service;

    // Endpoint to save the doctor's address information into the database.
    @PostMapping("/savedoctorAddress")
    public ResponseEntity<String> saveAddress(@RequestBody List<DoctorAddress> address) {
        service.saveDoctorAddress(address);
        logger.info("In Controller - Doctor Address Saved Successfully: " + address);
        return new ResponseEntity<>("Doctor Address Saved Successfully", HttpStatus.CREATED);
    }

    // Endpoint to retrieve the doctor's address information by doctorId from the database.
    @GetMapping("/getdoctorAddressById/{clinicId}")
    public ResponseEntity<DoctorAddress> getDoctorAddressByID(@PathVariable(value = "clinicId") Long clinicId) throws ProfileNotFoundException {
        DoctorAddress obj = service.getDoctorAddressByID(clinicId);
        logger.info("In Controller - Doctor Address Retrieved: " + obj);
        return ResponseEntity.ok().body(obj);
    }

    // Endpoint to retrieve the list of all doctors' addresses from the database.
    @GetMapping("/getAllDoctorAddress")
    public ResponseEntity<List<DoctorAddress>> getAllDoctorsAddress() throws DatabaseException {
        List<DoctorAddress> doctorAddressList = service.getAllDoctorsAddress();
        logger.info("In Controller - All Doctor Addresses Retrieved: " + doctorAddressList);
        return new ResponseEntity<>(doctorAddressList, HttpStatus.OK);
    }

    // Endpoint to update the doctor's address information by doctorId in the database.
    @PutMapping("/updateDoctorAddress/{clinicId}")
    public ResponseEntity<String> updateDoctorAddress(@PathVariable(value = "clinicId") long clinicId, @RequestBody DoctorAddress doctorAddress) throws ProfileNotFoundException {
        service.updateAddressByID(clinicId, doctorAddress);
        logger.info("In Controller - Doctor Address Updated Successfully: " + doctorAddress);
        return new ResponseEntity<>("Doctor Address updated Successfully", HttpStatus.CREATED);
    }

    // Endpoint to delete the doctor's address information by doctorId from the database.
    @DeleteMapping("/deletedoctorAddressById/{clinicId}")
    public ResponseEntity<String> deleteAddressByID(@PathVariable(value = "clinicId") long clinicId) throws ProfileNotFoundException {
        service.deleteAddressByID(clinicId);
        logger.info("In Controller - Doctor Address Deleted Successfully with ID: " + clinicId);
        return new ResponseEntity<>("Doctor Address deleted Successfully", HttpStatus.OK);
    }
    
    
    @GetMapping("/by-doctor/{doctorId}")
    public List<DoctorAddress> getAddressesByDoctorId(@PathVariable long doctorId) {
        return service.getAddressesByDoctorId(doctorId);
    }

}
