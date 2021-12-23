package com.java.assignment.api.response.pojo;

public class UserBasicInformationRequest {

	private String oldUserId;
	private String userId;
	private String name;
	private String dateOfBirth;
	private String aadharNumber;
	private String gender;
	private String email;
	private String phone;
	private String fcmToken;

	public String getOldUserId() {
		return oldUserId;
	}

	public void setOldUserId(String oldUserId) {
		this.oldUserId = oldUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	@Override
	public String toString() {
		return "UserBasicInformationRequest [userId=" + userId + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", aadharNumber=" + aadharNumber + ", gender=" + gender +  ", email=" + email
				+ ", phone=" + phone + "]";
	}

}