package com.oneHealth.DoctorRegistration.service;

import java.util.List;

import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorAddress;

/**
 * The DoctorAddressService interface defines the contract for performing operations related
 * to DoctorAddress. It declares methods for saving, retrieving, updating, and deleting doctor addresses.
 * 
 * Note: Make sure to import the required entities and exceptions from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1.0
 */
public interface DoctorAddressService {

    // Method to save a DoctorAddress object in the database.
    DoctorAddress saveDoctorAddress(DoctorAddress address);

    // Method to retrieve DoctorAddress by its ID and handle AddressNotFoundException if the address for the given doctorId is not found.
    DoctorAddress getDoctorAddressByID(Long doctor_id) throws ProfileNotFoundException;

    // Method to retrieve a list of all DoctorAddress objects from the database and handle DatabaseException if any occurs.
    List<DoctorAddress> getAllDoctorsAddress() throws DatabaseException;

    // Method to update DoctorAddress by its ID and handle AddressNotFoundException if the address for the given doctorId is not found.
    DoctorAddress updateAddressByID(long doctorId, DoctorAddress doctorAddress) throws ProfileNotFoundException;

    // Method to delete DoctorAddress by its ID and handle AddressNotFoundException if the address for the given doctorId is not found.
    DoctorAddress deleteAddressByID(long doctorId) throws ProfileNotFoundException;
    
    List<DoctorAddress> getAddressesByDoctorId(long doctorId);

}
