package com.oneHealth.DoctorRegistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Specialization 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long specId;
	private String name;
	
	public Specialization() {
		
	}

	public Specialization(long specId, String name) {
		super();
		this.specId = specId;
		this.name = name;
	}

	public long getSpecId() {
		return specId;
	}

	public void setSpecId(long specId) {
		this.specId = specId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Specialization [specId=" + specId + ", name=" + name + "]";
	}
	
	
	
	
}
