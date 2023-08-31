package com.oneHealth.DoctorRegistration.service;

import java.util.List;
import java.util.Set;

import com.oneHealth.DoctorRegistration.DTO.DocumentsDTO;
import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorProfile;
import com.oneHealth.DoctorRegistration.model.Specialization;

/**
 * The ProfileService interface defines the contract for managing doctor profile-related operations.
 * This interface provides methods to save doctor profile information into the database.
 * @author Anup
 * @version 3.9.10
 */
public interface ProfileService {

    /**
     * Saves the doctor profile information into the database.
     *+
     * @param profile The DoctorProfile object containing the doctor's profile details.
     * @return The saved DoctorProfile object.
     * @throws DatabaseException If there is an issue while interacting with the database.
     */
	DoctorProfile SaveDoctorProfile(DoctorProfile profile) throws DatabaseException; 
	
	
	/**
     * Retrieves a doctor profile from the database based on the provided ID.
     *
     * @param id The ID of the doctor profile to retrieve.
     * @return The DoctorProfile object with the specified ID.
     * @throws ProfileNotFoundException If no doctor profile is found with the given ID.
     */
	DoctorProfile getProfileByID(long doctor_id) throws ProfileNotFoundException;
	
	
	
	
	/**
	 * Retrieves all doctor profiles from the database.
	 *
	 * @return List of DoctorProfile objects representing all doctor profiles in the database.
	 * @throws DatabaseException If there is an issue while retrieving the doctor profiles from the database.
	 */
	List<DoctorProfile> getAllDoctorsProfile() throws DatabaseException;
	
	
	
	
	/**
     * Updates a doctor profile from the database based on the provided ID.
     *
     * @param id The ID of the doctor profile to retrieve.
     * @return The DoctorProfile object with the specified ID.
     * @throws ProfileNotFoundException If no doctor profile is found with the given ID.
     */
	DoctorProfile updateProfile(long doctor_id , DoctorProfile profile) throws ProfileNotFoundException;
	
	
	
	/**
	 * Deletes a doctor's profile by the given doctor_id.
	 *
	 * @param doctor_id The ID of the doctor's profile to be deleted.
	 * @throws ProfileNotFoundException If no profile is found with the given doctor_id.
	 */
	void deleteDoctorProfile(long doctor_id) throws ProfileNotFoundException;
	
	
	List<DoctorProfile> getDoctorsByCityAndSpecialization(String city, String specialization);
	
	List<DoctorProfile> getDoctorsBySpecialization(String specialization);
	
	Boolean updateDocuments(long doctor_id,DocumentsDTO documents);
	
	boolean updateSpecializationName(Long specializationId, String newName);
	
	boolean removeSpecializationFromDoctor(Long doctorId, long specializationId);
	
	
	
	
}
