package com.oneHealth.DoctorRegistration.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorRegistration;
import com.oneHealth.DoctorRegistration.repository.RegistrationRepository;
import com.oneHealth.DoctorRegistration.service.RegistrationService;



/**
 * This class provides the implementation for the RegistrationService interface.
 * It handles the business logic for registering doctors and retrieving doctor registration details.
 * @author Madhavi
 * @version 3.9.10
 */
@Service
public class RegistrationServiceImplementation implements RegistrationService {

    @Autowired
    RegistrationRepository repo;
    
    
    

    /**
     * Saves the registration details of a doctor.
     *
     * @param reg The DoctorRegistration object containing the details of the doctor to be registered.
     * @return The DoctorRegistration object with the saved registration details.
     * @throws DatabaseException If there is an error while saving the registration details to the database.
     */
    @Override
    public DoctorRegistration saveRegistrationDetails(DoctorRegistration reg) throws DatabaseException {
    	// Check if the email already exists in the database
        Optional<DoctorRegistration> existingDoctor = repo.findByEmail(reg.getEmail());
        if (existingDoctor.isPresent()) {
            throw new DatabaseException("Email already exists. Please use a different email address.");
        }
    	
    	try 
    	{
            return repo.save(reg);
        } 
    	catch (Exception e) {
            throw new DatabaseException("Error while saving registration details to the database: " + e.getMessage());
        }
    }
    
    
    
    
    

    /**
     * Retrieves the registration details of a doctor by their profile ID.
     *
     * @param profile_id The profile ID of the doctor to be retrieved.
     * @return The DoctorRegistration object containing the details of the doctor with the specified profile ID.
     * @throws ProfileNotFoundException If the profile ID does not match any registered doctor.
     */
    @Override
    public DoctorRegistration findProfileByID(long profile_id) throws ProfileNotFoundException {
        return repo.findById(profile_id).orElseThrow(
                () -> new ProfileNotFoundException("No Profile Found With This ID: " + profile_id)
        );
    }
    
    
    
    
    
    
    
    // Retrieve a list of all registered doctors from the database using the repository.
    // The findAll() method of the repository returns all the records in the database table.
    @Override
    public List<DoctorRegistration> getAllDoctors() throws DatabaseException
    {
        return repo.findAll();
    }





    /**
     * Updates the status of a doctor's registration identified by the given profile ID.
     *
     * @param profile_id The profile ID of the doctor whose status needs to be updated.
     * @param reg        The DoctorRegistration object containing the updated status.
     * @return The updated DoctorRegistration object after successfully updating the status.
     * @throws ProfileNotFoundException If no doctor's registration is found with the given profile ID.
     */
    @Override
	public DoctorRegistration updateDoctorStatus(long profile_id , DoctorRegistration reg) throws ProfileNotFoundException {
		
		DoctorRegistration registration = repo.findById(profile_id).orElseThrow(
                () -> new ProfileNotFoundException("No Profile Found With This ID: " + profile_id)
        );
		
		registration.setStatus(reg.getStatus());
		
		return repo.save(registration);
	}
}
