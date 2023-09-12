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
    
    
    
    /**
     * Autowired field for injecting the DoctorAddressService, which provides business logic for doctor's address operations.
     */
    @Autowired
    private DoctorAddressService service;

   
    
    /**
     * Endpoint to save the doctor's address information into the database.
     *
     * @param address List of DoctorAddress objects containing the address details to be saved.
     * @return ResponseEntity<String> A response indicating the success or failure of the operation.
     */
    @PostMapping("/savedoctorAddress")
    public ResponseEntity<String> saveAddress(@RequestBody List<DoctorAddress> address) {
        try {
            // Call the service to save the doctor's address information.
            service.saveDoctorAddress(address);
            
            // Log a success message.
            logger.info("In Controller - Doctor Address Saved Successfully: " + address);
            
            // Return a success response.
            return new ResponseEntity<>("Doctor Address Saved Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle the case where there's an error while saving the doctor's address.
            logger.error("Error while saving doctor address: " + e.getMessage());
            
            // Return an error response.
            return new ResponseEntity<>("Failed to save doctor address", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


  
    
    
    /**
     * Endpoint to retrieve the doctor's address information by clinic ID.
     *
     * @param clinicId The unique identifier of the clinic whose address information is to be retrieved.
     * @return ResponseEntity<DoctorAddress> A response containing the retrieved DoctorAddress object.
     */
    
    @GetMapping("/getdoctorAddressById/{clinicId}")
    public ResponseEntity<DoctorAddress> getDoctorAddressByID(@PathVariable(value = "clinicId") Long clinicId) {
        try {
            // Call the service to retrieve the doctor's address information by clinic ID.
            DoctorAddress obj = service.getDoctorAddressByID(clinicId);
            
            // Log a success message.
            logger.info("In Controller - Doctor Address Retrieved: " + obj);
            
            // Return a success response with the retrieved DoctorAddress object.
            return ResponseEntity.ok().body(obj);
        } catch (ProfileNotFoundException e) {
            // Handle the case where the clinic ID is not found.
            logger.error("Profile not found for clinic ID: " + clinicId);
            
            // Return a not found response.
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Handle other exceptions or errors that may occur during retrieval.
            logger.error("Error while retrieving doctor address: " + e.getMessage());
            
            // Return an internal server error response.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    
    
    
    /**
     * Endpoint to retrieve all doctor's addresses stored in the database.
     *
     * @return ResponseEntity<List<DoctorAddress>> A response containing a list of all DoctorAddress objects.
     */
    
    @GetMapping("/getAllDoctorAddress")
    public ResponseEntity<List<DoctorAddress>> getAllDoctorsAddress() {
        try {
            // Call the service to retrieve a list of all doctor's addresses.
            List<DoctorAddress> doctorAddressList = service.getAllDoctorsAddress();
            
            // Log a success message.
            logger.info("In Controller - All Doctor Addresses Retrieved: " + doctorAddressList);
            
            // Return a success response with the list of DoctorAddress objects.
            return new ResponseEntity<>(doctorAddressList, HttpStatus.OK);
        } catch (DatabaseException e) {
            // Handle the case where there's an error while retrieving all doctor's addresses.
            logger.error("Error while retrieving all doctor addresses: " + e.getMessage());
            
            // Return an internal server error response.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    
    
    /**
     * Endpoint to update the doctor's address information by clinic ID in the database.
     *
     * @param clinicId       The unique identifier of the clinic whose address is to be updated.
     * @param doctorAddress  The updated DoctorAddress object containing the new address details.
     * @return ResponseEntity<String> A response indicating the success or failure of the update operation.
     */
    
    @PutMapping("/updateDoctorAddress/{clinicId}")
    public ResponseEntity<String> updateDoctorAddress(@PathVariable(value = "clinicId") long clinicId, @RequestBody DoctorAddress doctorAddress) {
        try {
            // Call the service to update the doctor's address information by clinic ID.
            service.updateAddressByID(clinicId, doctorAddress);
            
            // Log a success message.
            logger.info("In Controller - Doctor Address Updated Successfully: " + doctorAddress);
            
            // Return a success response.
            return new ResponseEntity<>("Doctor Address updated Successfully", HttpStatus.CREATED);
        } catch (ProfileNotFoundException e) {
            // Handle the case where the clinic ID is not found.
            logger.error("Profile not found for clinic ID: " + clinicId);
            
            // Return a not found response.
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Handle other exceptions or errors that may occur during the update.
            logger.error("Error while updating doctor address: " + e.getMessage());
            
            // Return an internal server error response.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    

    /**
     * Endpoint to delete the doctor's address information by clinic ID from the database.
     *
     * @param clinicId The unique identifier of the clinic whose address is to be deleted.
     * @return ResponseEntity<String> A response indicating the success or failure of the deletion operation.
     */
    
      @DeleteMapping("/deletedoctorAddressById/{clinicId}")
    public ResponseEntity<String> deleteAddressByID(@PathVariable(value = "clinicId") long clinicId) {
        try {
            // Call the service to delete the doctor's address information by clinic ID.
            service.deleteAddressByID(clinicId);
            
            // Log a success message.
            logger.info("In Controller - Doctor Address Deleted Successfully with ID: " + clinicId);
            
            // Return a success response.
            return new ResponseEntity<>("Doctor Address deleted Successfully", HttpStatus.OK);
        } catch (ProfileNotFoundException e) {
            // Handle the case where the clinic ID is not found.
            logger.error("Profile not found for clinic ID: " + clinicId);
            
            // Return a not found response.
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // Handle other exceptions or errors that may occur during the deletion.
            logger.error("Error while deleting doctor address: " + e.getMessage());
            
            // Return an internal server error response.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
      
      

    
    
    /**
     * Endpoint to retrieve a list of DoctorAddress objects by the unique identifier of a doctor (doctorId).
     *
     * @param doctorId The unique identifier of the doctor whose addresses are to be retrieved.
     * @return List<DoctorAddress> A list of DoctorAddress objects associated with the specified doctor.
     */
      
    @GetMapping("/by-doctor/{doctorId}")
    public List<DoctorAddress> getAddressesByDoctorId(@PathVariable long doctorId) {
        // Call the service to retrieve a list of DoctorAddress objects by doctorId.
        return service.getAddressesByDoctorId(doctorId);
    }

}
