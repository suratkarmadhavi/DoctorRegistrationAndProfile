package com.oneHealth.DoctorRegistration.service;

import java.util.List;

import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorRegistration;

/**
 * This interface defines the contract for managing doctor registration in the application.
 * It declares methods for saving doctor registration details and retrieving them by profile ID.
 * @author Anup
 * @version 3.9.10
 */
public interface RegistrationService {

    /**
     * Saves the registration details of a doctor.
     *
     * @param reg The DoctorRegistration object containing the details of the doctor to be registered.
     * @return The DoctorRegistration object with the saved registration details.
     * @throws DatabaseException If there is an error while saving the registration details to the database.
     */
    DoctorRegistration saveRegistrationDetails(DoctorRegistration reg) throws DatabaseException;

    /**
     * Retrieves the registration details of a doctor by their profile ID.
     *
     * @param profile_id The profile ID of the doctor to be retrieved.
     * @return The DoctorRegistration object containing the details of the doctor with the specified profile ID.
     * @throws ProfileNotFoundException If the profile ID does not match any registered doctor.
     */
    DoctorRegistration findProfileByID(long profile_id) throws ProfileNotFoundException;
    
    /**
     * Retrieves a list of all registered doctors.
     *
     * @return A list of DoctorRegistration objects representing all registered doctors.
     * @throws DatabaseException If there is an error while fetching doctors from the database.
     */
    List<DoctorRegistration> getAllDoctors() throws DatabaseException;
    
    
    
    
    /**
     * Updates the status of a doctor's registration identified by the given profile ID.
     *
     * @param profile_id The profile ID of the doctor whose status needs to be updated.
     * @param reg        The DoctorRegistration object containing the updated status.
     * @return The updated DoctorRegistration object after successfully updating the status.
     * @throws ProfileNotFoundException If no doctor's registration is found with the given profile ID.
     */
    DoctorRegistration updateDoctorStatus(long profile_id , DoctorRegistration reg) throws ProfileNotFoundException;
}
