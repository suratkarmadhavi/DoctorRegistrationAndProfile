package com.oneHealth.DoctorRegistration.DTO;

import java.util.Set;
import com.oneHealth.DoctorRegistration.model.Specialization;

/**
 * Data Transfer Object (DTO) class representing a request to update a doctor's specializations.
 * This class is used to transfer a set of specializations for updating a doctor's profile.
 * 
 * @author Anup
 * @version 1.0
 */
public class UpdateSpecializationsRequest {
    private Set<Specialization> specializations; // Set of specializations to be updated for the doctor.

    // Default constructor for the UpdateSpecializationsRequest class.
    public UpdateSpecializationsRequest() {
    }

    /**
     * Parameterized constructor for UpdateSpecializationsRequest class.
     *
     * @param specializations A set of specializations to be updated for the doctor.
     */
    public UpdateSpecializationsRequest(Set<Specialization> specializations) {
        super();
        this.specializations = specializations;
    }

    /**
     * Getter method to retrieve the set of specializations.
     *
     * @return The set of specializations to be updated.
     */
    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    /**
     * Setter method to set the set of specializations.
     *
     * @param specializations The set of specializations to be updated.
     */
    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    @Override
    public String toString() {
        return "UpdateSpecializationsRequest [specializations=" + specializations + "]";
    }
}
