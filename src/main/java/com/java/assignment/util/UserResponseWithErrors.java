package com.java.assignment.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.assignment.dto.UserRequestPayload;
import com.java.assignment.model.Users;

public class UserResponseWithErrors {

	public List<Users> createdUsers;
	public Map<Integer, Map<String, UserRequestPayload>> emailErrors = new HashMap<>();
	public Map<Integer, Map<String, UserRequestPayload>> firstNameErrors = new HashMap<>();
	public Map<Integer, Map<String, UserRequestPayload>> mobileErrors = new HashMap<>();
	public Map<Integer, Map<Integer, UserRequestPayload>> pinCodeErrors = new HashMap<>();

	public List<Users> getCreatedUsers() {
		return createdUsers;
	}

	public void setCreatedUsers(List<Users> createdUsers) {
		this.createdUsers = createdUsers;
	}

	public Map<Integer, Map<String, UserRequestPayload>> getEmailErrors() {
		return emailErrors;
	}

	public void setEmailErrors(Integer emailErrorsCount, Map<String, UserRequestPayload> emailErrors) {
		this.emailErrors.put(emailErrorsCount, emailErrors);
	}

	public Map<Integer, Map<String, UserRequestPayload>> getFirstNameErrors() {
		return firstNameErrors;
	}

	public void setFirstNameErrors(Integer firstNameErrorsCount, Map<String, UserRequestPayload> firstNameErrors) {
		this.firstNameErrors.put(firstNameErrorsCount, firstNameErrors);
	}

	public Map<Integer, Map<String, UserRequestPayload>> getMobileErrors() {
		return mobileErrors;
	}

	public void setMobileErrors(Integer mobileErrorsCount, Map<String, UserRequestPayload> mobileErrors) {
		this.mobileErrors.put(mobileErrorsCount, mobileErrors);
	}

	public Map<Integer, Map<Integer, UserRequestPayload>> getPinCodeErrors() {
		return pinCodeErrors;
	}

	public void setPinCodeErrors(Integer pinCodeErrorsCount, Map<Integer, UserRequestPayload> pinCodeErrors) {
		this.pinCodeErrors.put(pinCodeErrorsCount, pinCodeErrors);
	}

	@Override
	public String toString() {
		return "UserResponseWithErrors [createdUsers=" + createdUsers + ", emailErrors=" + emailErrors
				+ ", firstNameErrors=" + firstNameErrors + ", mobileErrors=" + mobileErrors + ", pinCodeErrors="
				+ pinCodeErrors + "]";
	}
}
