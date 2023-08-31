package com.oneHealth.DoctorRegistration.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneHealth.DoctorRegistration.DTO.DocumentsDTO;
import com.oneHealth.DoctorRegistration.exceptions.DatabaseException;
import com.oneHealth.DoctorRegistration.exceptions.ProfileNotFoundException;
import com.oneHealth.DoctorRegistration.model.DoctorProfile;
import com.oneHealth.DoctorRegistration.model.Specialization;
import com.oneHealth.DoctorRegistration.repository.ProfileRepository;
import com.oneHealth.DoctorRegistration.repository.SpecializationRepository;
import com.oneHealth.DoctorRegistration.service.ProfileService;



/**
 * The ProfileServiceImplementation class provides the implementation of the ProfileService interface.
 * It handles the business logic for managing doctor profile-related operations.
 * @author Anup
 * @version 3.9.10
 */
@Service
public class ProfileServiceImplementation implements ProfileService {

    private static final Logger LOGGER = Logger.getLogger(ProfileServiceImplementation.class.getName());

    @Autowired
    private ProfileRepository repo;
    
    @Autowired
    private SpecializationRepository specRepo;

    /**
     * Saves the doctor profile information into the database.
     *
     * @param profile The DoctorProfile object containing the doctor's profile details.
     * @return The saved DoctorProfile object.
     * @throws DatabaseException If there is an issue while interacting with the database.
     */
    @Override
    public DoctorProfile SaveDoctorProfile(DoctorProfile profile) throws DatabaseException {
        LOGGER.info("In Service - Saving doctor profile: " + profile);
        return repo.save(profile);
    }

    /**
     * Retrieves a doctor profile from the database based on the provided ID.
     *
     * @param doctor_id The ID of the doctor profile to retrieve.
     * @return The DoctorProfile object with the specified ID.
     * @throws ProfileNotFoundException If no doctor profile is found with the given ID.
     */
    @Override
    public DoctorProfile getProfileByID(long doctor_id) throws ProfileNotFoundException {
        LOGGER.info("In Service - Retrieving doctor profile for ID: " + doctor_id);
        return repo.findById(doctor_id).orElseThrow(
            () -> new ProfileNotFoundException("No Profile Found With This ID: " + doctor_id)
        );
    }

    /**
     * Retrieves all doctor profiles from the database.
     *
     * @return List of DoctorProfile objects representing all doctor profiles in the database.
     * @throws DatabaseException If there is an issue while retrieving the doctor profiles from the database.
     */
    @Override
    public List<DoctorProfile> getAllDoctorsProfile() throws DatabaseException {
        LOGGER.info("In Service - Retrieving all doctor profiles");
        return repo.findAll();
    }

    /**
     * Updates the profile of a doctor identified by the given doctor_id with the provided DoctorProfile object.
     *
     * @param doctor_id The doctor_id of the doctor whose profile needs to be updated.
     * @param profile   The updated DoctorProfile object.
     * @return The updated DoctorProfile object after saving to the database.
     * @throws ProfileNotFoundException If no doctor's profile is found with the given doctor_id.
     */
    @Override
    public DoctorProfile updateProfile(long doctor_id, DoctorProfile profile) throws ProfileNotFoundException {
        LOGGER.info("In Service - Updating doctor profile for ID: " + doctor_id);
        DoctorProfile details = repo.findById(doctor_id).orElseThrow(
            () -> new ProfileNotFoundException("No Profile Found With This ID: " + doctor_id)
        );

        details.setFirst_name(profile.getFirst_name());
        details.setLast_name(profile.getLast_name());
        details.setEmail(profile.getEmail());
        details.setContact(profile.getContact());
        details.setCity(profile.getCity());
        details.setGender(profile.getGender());
        details.setBirth_date(profile.getBirth_date());
        details.setBlood_group(profile.getBlood_group());
        details.setDegree(profile.getDegree());
        details.setPassout_year(profile.getPassout_year());
        details.setUniversity(profile.getUniversity());
        details.setExperiance(profile.getExperiance());
        details.setBiography(profile.getBiography());
        details.setConsultationFees(profile.getConsultationFees());

        return repo.save(details);
    }

    /**
     * Deletes a doctor's profile by the given doctor_id.
     *
     * @param doctor_id The ID of the doctor's profile to be deleted.
     * @throws ProfileNotFoundException If no profile is found with the given doctor_id.
     */
    @Override
    public void deleteDoctorProfile(long doctor_id) throws ProfileNotFoundException {
        LOGGER.info("In Service - Deleting doctor profile for ID: " + doctor_id);
        DoctorProfile details = repo.findById(doctor_id).orElseThrow(
            () -> new ProfileNotFoundException("No Profile Found With This ID: " + doctor_id)
        );

        repo.delete(details);
    }

	@Override
	public List<DoctorProfile> getDoctorsByCityAndSpecialization(String city, String specialization) {
		return repo.findByCityAndSpecializations_Name(city, specialization);
	}
	
	@Override
    public List<DoctorProfile> getDoctorsBySpecialization(String specialization) {

        return repo.findBySpecializations_Name(specialization);

    }

	@Override
	public Boolean updateDocuments(long doctor_id, DocumentsDTO documents) {
		Optional<DoctorProfile> optionalDoctor = repo.findById(doctor_id);
        
        if (optionalDoctor.isPresent()) {
            DoctorProfile doctor = optionalDoctor.get();
            doctor.setPhotoId(documents.getPhotoId());
            doctor.setPanId(documents.getPanId());
            doctor.setAadharId(documents.getAadharId());
            doctor.setMedicalCertId(documents.getMedicalCertId());
            
            repo.save(doctor);
            return true;
        }
        
        return false;
    
	}

	@Override
	public boolean updateSpecializationName(Long specializationId, String newName) {
		Optional<Specialization> optionalSpecialization = specRepo.findById(specializationId);
        
        if (optionalSpecialization.isPresent()) {
            Specialization specialization = optionalSpecialization.get();
            specialization.setName(newName);
            
            specRepo.save(specialization);
            return true;
        }
        
        return false;
	}

	@Override
	public boolean removeSpecializationFromDoctor(Long doctorId, long specializationId) {
		Optional<DoctorProfile> optionalDoctor = repo.findById(doctorId);
        
        if (optionalDoctor.isPresent()) {
            DoctorProfile doctor = optionalDoctor.get();
            
            // Remove the specialization from the doctor's specializations set
            doctor.getSpecializations().removeIf(s -> s.getSpecId()==(specializationId));
            repo.save(doctor);
            
            return true;
        }
        
        return false;
	}

	
	
	
	





	
}
