package com.oneHealth.DoctorRegistration.DTO;

import java.util.Set;

import com.oneHealth.DoctorRegistration.model.Specialization;

public class UpdateSpecializationsRequest {
	
	private Set<Specialization> specializations;

	
	public UpdateSpecializationsRequest() {

	}


	public UpdateSpecializationsRequest(Set<Specialization> specializations) {
		super();
		this.specializations = specializations;
	}


	public Set<Specialization> getSpecializations() {
		return specializations;
	}


	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}


	@Override
	public String toString() {
		return "UpdateSpecializationsRequest [specializations=" + specializations + "]";
	}

	
	
	
}
