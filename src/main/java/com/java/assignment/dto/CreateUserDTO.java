package com.java.assignment.dto;

import java.util.List;

public class CreateUserDTO {

	public List<UserRequestPayload> userRequestPayload;

	public List<UserRequestPayload> getUserRequestPayload() {
		return userRequestPayload;
	}

	public void setUserRequestPayloads(List<UserRequestPayload> userRequestPayload) {
		this.userRequestPayload = userRequestPayload;
	}

	@Override
	public String toString() {
		return "CreateUserDTO [userRequestPayload=" + userRequestPayload + "]";
	}
}