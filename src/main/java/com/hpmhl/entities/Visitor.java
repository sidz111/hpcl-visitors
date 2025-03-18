package com.hpmhl.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Visitor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer tokenNo;
    
    private Integer srno;
    
    private String aadharNo;
    
    private String fullName;
    
    private String mobileNo;
    
    private String address;
    
    private String toSeeWhom;
    
    private String purposeToVisit;
    
    private Boolean isRegular;
    
    private String date;
    
    private String workingAs = "visitor";
    
    private String photo;
    
    private String idPhoto;
    
    private String qrCodeValue;
    
    private String qrpath;
    
    private String timeIn;
    
    private String timeOut;
    
    private Boolean restricted;
    
    private String access;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(Integer tokenNo) {
		this.tokenNo = tokenNo;
	}

	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getToSeeWhom() {
		return toSeeWhom;
	}

	public void setToSeeWhom(String toSeeWhom) {
		this.toSeeWhom = toSeeWhom;
	}

	public String getPurposeToVisit() {
		return purposeToVisit;
	}

	public void setPurposeToVisit(String purposeToVisit) {
		this.purposeToVisit = purposeToVisit;
	}

	public Boolean getIsRegular() {
		return isRegular;
	}

	public void setIsRegular(Boolean isRegular) {
		this.isRegular = isRegular;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWorkingAs() {
		return workingAs;
	}

	public void setWorkingAs(String workingAs) {
		this.workingAs = workingAs;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getQrCodeValue() {
		return qrCodeValue;
	}

	public void setQrCodeValue(String qrCodeValue) {
		this.qrCodeValue = qrCodeValue;
	}

	public String getQrpath() {
		return qrpath;
	}

	public void setQrpath(String qrpath) {
		this.qrpath = qrpath;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public Boolean getRestricted() {
		return restricted;
	}

	public void setRestricted(Boolean restricted) {
		this.restricted = restricted;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

}
