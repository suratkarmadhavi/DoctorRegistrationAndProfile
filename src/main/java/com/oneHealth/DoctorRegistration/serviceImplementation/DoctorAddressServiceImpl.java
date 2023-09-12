package com.oneHealth.DoctorRegistration.serviceImplementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorAddress;
import com.oneHealth.DoctorRegistration.repository.DoctorAddressRepository;
import com.oneHealth.DoctorRegistration.service.DoctorAddressService;


/**
 * The DoctorAddressServiceImpl class is responsible for implementing the business logic
 * for managing address details of doctors. It interacts with the DoctorAddressRepository to perform CRUD operations.
 *
 * Note: Make sure to import the required entities, exceptions, and repositories from the appropriate packages.
 *
 * @author Madhavi
 * @version 1.0
 */
@Service
public class DoctorAddressServiceImpl implements DoctorAddressService {

    private final Logger logger = LoggerFactory.getLogger(DoctorAddressServiceImpl.class);

    @Autowired
    private DoctorAddressRepository repo;
    /**
     * Saves a list of doctor addresses to the database.
     *
     * @param address The list of DoctorAddress objects to be saved.
     * @return The saved list of DoctorAddress objects.
     */
    @Override
    public List<DoctorAddress> saveDoctorAddress(List<DoctorAddress> address) {
        return repo.saveAll(address);
    }
    
    
    
    /**
     * Retrieves a DoctorAddress by its clinic ID and handles ProfileNotFoundException
     * if the address for the given clinicId is not found.
     *
     * @param clinicId The ID of the DoctorAddress to retrieve.
     * @return The retrieved DoctorAddress.
     * @throws ProfileNotFoundException If no address is found with the specified clinicId.
     */
    @Override
    public DoctorAddress getDoctorAddressByID(Long clinicId) throws ProfileNotFoundException {
        DoctorAddress address = repo.findById(clinicId)
                .orElseThrow(() -> new ProfileNotFoundException("No Address Found with this ID: " + clinicId));
        logger.info("In Service - Doctor Address Retrieved: " + address);
        return address;
    }

    
    /**
     * Retrieves a list of all DoctorAddress objects from the database and handles
     * DatabaseException if any database-related error occurs.
     *
     * @return A list of all DoctorAddress objects in the database.
     * @throws DatabaseException If a database error occurs during retrieval.
     */
    @Override
    public List<DoctorAddress> getAllDoctorsAddress() throws DatabaseException {
        List<DoctorAddress> addressList = repo.findAll();
        logger.info("In Service - All Doctor Addresses Retrieved: " + addressList);
        return addressList;
    }
    
    
    /**
     * Updates a DoctorAddress by its clinic ID and handles ProfileNotFoundException
     * if the address for the given clinicId is not found.
     *
     * @param clinicId       The ID of the DoctorAddress to update.
     * @param updatedAddress The new DoctorAddress with updated information.
     * @return The updated DoctorAddress.
     * @throws ProfileNotFoundException If no address is found with the specified clinicId.
     */
    @Override
    public DoctorAddress updateAddressByID(long clinicId, DoctorAddress updatedAddress) throws ProfileNotFoundException {
        DoctorAddress doctorAddress = repo.findById(clinicId)
                .orElseThrow(() -> new ProfileNotFoundException("No Doctor Address found with this ID: " + clinicId));

        // Update address properties with the new values from updatedAddress
        doctorAddress.setClinicName(updatedAddress.getClinicName());
        doctorAddress.setAddress(updatedAddress.getAddress());
        doctorAddress.setLocation(updatedAddress.getLocation());
        doctorAddress.setCity(updatedAddress.getCity());
        doctorAddress.setPinCode(updatedAddress.getPinCode());

        DoctorAddress updatedAddressResult = repo.save(doctorAddress);
        logger.info("In Service - Doctor Address Updated Successfully: " + updatedAddressResult);
        return updatedAddressResult;
    }

    /**
     * Deletes a DoctorAddress by its clinic ID and handles ProfileNotFoundException
     * if the address for the given clinicId is not found.
     *
     * @param clinicId The ID of the DoctorAddress to delete.
     * @return The deleted DoctorAddress.
     * @throws ProfileNotFoundException If no address is found with the specified clinicId.
     */
    @Override
    public DoctorAddress deleteAddressByID(long clinicId) throws ProfileNotFoundException {
        DoctorAddress doctorAddress = repo.findById(clinicId)
                .orElseThrow(() -> new ProfileNotFoundException("No Doctor Address found with this ID: " + clinicId));

        repo.delete(doctorAddress);
        logger.info("In Service - Doctor Address Deleted Successfully with ID: " + clinicId);
        return doctorAddress;
    }


    /**
     * Retrieves a list of DoctorAddress objects by a given doctor's ID.
     *
     * @param doctorId The ID of the doctor for whom addresses are retrieved.
     * @return A list of DoctorAddress objects associated with the specified doctorId.
     */
    @Override
    public List<DoctorAddress> getAddressesByDoctorId(long doctorId) {
        return repo.findByDoctorId(doctorId);
    }

}
