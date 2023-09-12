package com.oneHealth.DoctorRegistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing DoctorAddress information.
 * This class is mapped to a database table to store address details of doctors.
 * 
 * Note: Make sure to import the required annotations from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1.0
 */
@Entity
public class DoctorAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinicId; // Primary key field for the DoctorAddress table
    private String clinicName; // Field representing the name of the clinic where the doctor practices
    private String address; // Field representing the complete address of the clinic
    private String location; // Field representing the location or area of the clinic
    private String city; // Field representing the city where the clinic is located
    private Long pinCode; // Field representing the postal code or PIN code of the clinic's location
    private long doctorId;

    public DoctorAddress() {
        super();
    }

    public DoctorAddress(Long clinicId, String clinicName, String address, String location, String city, Long pinCode, long doctorId) {
        super();
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.address = address;
        this.location = location;
        this.city = city;
        this.pinCode = pinCode;
        this.doctorId = doctorId;
    }

    public Long getClinicId() {
        return clinicId; // Getter method for clinicId
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId; // Setter method for clinicId
    }

    public String getClinicName() {
        return clinicName; // Getter method for clinicName
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName; // Setter method for clinicName
    }

    public String getAddress() {
        return address; // Getter method for address
    }

    public void setAddress(String address) {
        this.address = address; // Setter method for address
    }

    public String getLocation() {
        return location; // Getter method for location
    }

    public void setLocation(String location) {
        this.location = location; // Setter method for location
    }

    public String getCity() {
        return city; // Getter method for city
    }

    public void setCity(String city) {
        this.city = city; // Setter method for city
    }

    public Long getPinCode() {
        return pinCode; // Getter method for pinCode
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode; // Setter method for pinCode
    }

    public long getDoctorId() {
        return doctorId; // Getter method for doctorId
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId; // Setter method for doctorId
    }
}
