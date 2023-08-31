package com.oneHealth.DoctorRegistration.DTO;

public class DocumentsDTO {
	private String photoId;
    private String panId;
    private String aadharId;
    private String medicalCertId;
	
    
    public DocumentsDTO() {
		
	}


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
		return "DocumentsDTO [photoId=" + photoId + ", panId=" + panId + ", aadharId=" + aadharId + ", medicalCertId="
				+ medicalCertId + "]";
	}
    
    
}
