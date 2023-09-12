package com.oneHealth.DoctorRegistration.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


/**
 * This class represents the DoctorProfile entity used to store information about a doctor's profile.
 * Doctors' personal details, qualifications, experience, and document links are stored as attributes.
 * @author Anup
 * @version 1.0
 */
@Entity
public class DoctorProfile 
{
	// Primary key for the entity. The @Id annotation marks this field as the primary key.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Value(value="101")
	private long doctor_id;
	
	private String first_name;
	private String last_name;
	private String email;
	private String contact;
	private String city;
	private String license_number;
	private Date birth_date;
	private String gender;
	private String blood_group;
	private String degree;
	private int passout_year;
	private String university;
	private String biography;
	private float experiance;
	private String photoId;
	private String panId;
	private String aadharId;
	private String medicalCertId;
	private int consultationFees;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
	    name = "doctor_specialization",
	    joinColumns = @JoinColumn(name = "doctor_id"),
	    inverseJoinColumns = @JoinColumn(name = "specialization_id")
	)
	private Set<Specialization> specializations = new HashSet<>();
	
	
	// Default constructor required by JPA. Should be available for every entity.
	public DoctorProfile() 
	{
		
	}


	public DoctorProfile(long doctor_id, String first_name, String last_name, String email, String contact, String city,
			String license_number, Date birth_date, String gender, String blood_group, String degree, int passout_year,
			String university, String biography, float experiance, String photoId, String panId, String aadharId,
			String medicalCertId, int consultationFees, Set<Specialization> specializations) {
		super();
		this.doctor_id = doctor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.contact = contact;
		this.city = city;
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
		this.medicalCertId = medicalCertId;
		this.consultationFees = consultationFees;
		this.specializations = specializations;
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


	public String getLicense_number() {
		return license_number;
	}


	public void setLicense_number(String license_number) {
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


	public String getMedicalCertId() {
		return medicalCertId;
	}


	public void setMedicalCertId(String medicalCertId) {
		this.medicalCertId = medicalCertId;
	}


	public int getConsultationFees() {
		return consultationFees;
	}


	public void setConsultationFees(int consultationFees) {
		this.consultationFees = consultationFees;
	}


	public Set<Specialization> getSpecializations() {
		return specializations;
	}


	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}


	@Override
	public String toString() {
		return "DoctorProfile [doctor_id=" + doctor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", contact=" + contact + ", city=" + city + ", license_number=" + license_number
				+ ", birth_date=" + birth_date + ", gender=" + gender + ", blood_group=" + blood_group + ", degree="
				+ degree + ", passout_year=" + passout_year + ", university=" + university + ", biography=" + biography
				+ ", experiance=" + experiance + ", photoId=" + photoId + ", panId=" + panId + ", aadharId=" + aadharId
				+ ", medicalCertId=" + medicalCertId + ", consultationFees=" + consultationFees + ", specializations="
				+ specializations + "]";
	}


	
	
}
