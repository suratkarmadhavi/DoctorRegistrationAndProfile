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

    // Method to save a DoctorAddress object in the database.
    @Override
    public DoctorAddress saveDoctorAddress(DoctorAddress address) {
        return repo.save(address);
    }

    // Method to retrieve DoctorAddress by its ID and handle AddressNotFoundException if the address for the given doctorId is not found.
    @Override
    public DoctorAddress getDoctorAddressByID(Long doctor_id) throws ProfileNotFoundException {
        DoctorAddress address = repo.findById(doctor_id)
                .orElseThrow(() -> new ProfileNotFoundException("No Address Found with this ID: " + doctor_id));
        logger.info("In Service - Doctor Address Retrieved: " + address);
        return address;
    }

    // Method to retrieve a list of all DoctorAddress objects from the database and handle DatabaseException if any occurs.
    @Override
    public List<DoctorAddress> getAllDoctorsAddress() throws DatabaseException {
        List<DoctorAddress> addressList = repo.findAll();
        logger.info("In Service - All Doctor Addresses Retrieved: " + addressList);
        return addressList;
    }

    // Method to update DoctorAddress by its ID and handle AddressNotFoundException if the address for the given doctorId is not found.
    @Override
    public DoctorAddress updateAddressByID(long doctorId, DoctorAddress updatedAddress) throws ProfileNotFoundException {
        DoctorAddress doctorAddress = repo.findById(doctorId)
                .orElseThrow(() -> new ProfileNotFoundException("No Doctor Address found with this ID: " + doctorId));

        // Update address property with the new value from updatedAddress
        doctorAddress.setAddress(updatedAddress.getAddress());

        DoctorAddress updatedAddressResult = repo.save(doctorAddress);
        logger.info("In Service - Doctor Address Updated Successfully: " + updatedAddressResult);
        return updatedAddressResult;
    }

    // Method to delete DoctorAddress by its ID and handle AddressNotFoundException if the address for the given doctorId is not found.
    @Override
    public DoctorAddress deleteAddressByID(long doctorId) throws ProfileNotFoundException {
        DoctorAddress doctorAddress = repo.findById(doctorId)
                .orElseThrow(() -> new ProfileNotFoundException("No Doctor Address found with this ID: " + doctorId));

        repo.delete(doctorAddress);
        logger.info("In Service - Doctor Address Deleted Successfully with ID: " + doctorId);
        return doctorAddress;
    }

	@Override
	public List<DoctorAddress> getAddressesByDoctorId(long doctorId) {
		return repo.findByDoctorId(doctorId);
	}

}
