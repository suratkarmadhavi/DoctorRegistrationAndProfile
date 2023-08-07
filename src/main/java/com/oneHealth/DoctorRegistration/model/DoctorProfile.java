package com.oneHealth.DoctorRegistration.model;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


/**
 * This class represents the DoctorProfile entity used to store information about a doctor's profile.
 * Doctors' personal details, qualifications, experience, and document links are stored as attributes.
 * @author Anup
 * @version 3.9.10
 */
@Entity
public class DoctorProfile 
{
	// Primary key for the entity. The @Id annotation marks this field as the primary key.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Value(value="101")
	private long doctor_id;
	
	@NotEmpty
	private String first_name;
	
	@NotEmpty
	private String last_name;
	
	@Email
	private String email;
	
	@NotEmpty
	private String contact;
	
	private String city;

	
	@NotEmpty
	private String specialization;
	
	@NotEmpty
	private String license_number;
	
	private Date birth_date;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String blood_group;
	
	@NotEmpty
	private String degree;
	
	
	private int passout_year;
	
	@NotEmpty
	private String university;
	
	@NotEmpty
	private String biography;
	
	
	private float experiance;
	
	@NotEmpty
	private String photoId;
	
	@NotEmpty
	private String panId;
	
	@NotEmpty
	private String aadharId;
	
	
	// Default constructor required by JPA. Should be available for every entity.
	public DoctorProfile() 
	{
		
	}

	public DoctorProfile(long doctor_id, String first_name, String last_name, String email, String contact, String city ,
			String specialization, String license_number, Date birth_date, String gender, String blood_group,
			String degree, int passout_year, String university, String biography, int experiance, String photoId,
			String panId, String aadharId) {
		super();
		this.doctor_id = doctor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.contact = contact;
		this.city = city;
		this.specialization = specialization;
		this.license_number = license_number;
		this.birth_date = birth_date;
		this.gender = gender;
		this.blood_group = blood_group;
		this.degree = degree;
		this.passout_year = passout_year;
		this.university = university;
		this.biography = biography;
		this.experiance = experiance;
		this.photoId = photoId;
		this.panId = panId;
		this.aadharId = aadharId;
		
	}

	public long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(long doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLicense_number() {
		return license_number;
	}

	public void setLicense_nummber(String license_number) {
		this.license_number = license_number;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getPassout_year() {
		return passout_year;
	}

	public void setPassout_year(int passout_year) {
		this.passout_year = passout_year;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public float getExperiance() {
		return experiance;
	}

	public void setExperiance(float experiance) {
		this.experiance = experiance;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	
	
	
	
	
	
}
