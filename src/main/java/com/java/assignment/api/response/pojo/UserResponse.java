package com.java.assignment.api.response.pojo;

public class UserResponse {

	public boolean success;
	public Object data;
	public String message;
	public int statusCode;

	public UserResponse(boolean success, Object data, String message, int statusCode) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;
		this.statusCode = statusCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
