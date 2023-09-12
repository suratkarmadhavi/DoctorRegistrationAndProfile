package com.oneHealth.DoctorRegistration.DTO;

/**
 * Data Transfer Object (DTO) class representing documents associated with doctor registration.
 * This class is used to transfer document-related information for doctor registration.
 * 
 * @author Anup
 * @version 1.0
 */
public class DocumentsDTO {
    private String photoId;         // Unique identifier for the doctor's photo ID.
    private String panId;           // Unique identifier for the doctor's PAN card.
    private String aadharId;        // Unique identifier for the doctor's Aadhar card.
    private String medicalCertId;   // Unique identifier for the doctor's medical certification.

    // Constructors, getters, and setters are provided below...

    // Default constructor for the DocumentsDTO class.
    public DocumentsDTO() {
    }

    // Parameterized constructor for DocumentsDTO class to initialize all fields.
    public DocumentsDTO(String photoId, String panId, String aadharId, String medicalCertId) {
        super();
        this.photoId = photoId;
        this.panId = panId;
        this.aadharId = aadharId;
        this.medicalCertId = medicalCertId;
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

    @Override
    public String toString() {
        return "DocumentsDTO [photoId=" + photoId + ", panId=" + panId + ", aadharId=" + aadharId
             + ", medicalCertId=" + medicalCertId + "]";
    }
}
