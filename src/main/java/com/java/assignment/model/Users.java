package com.java.assignment.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

	@Column(name = "user_id")
	private int user_id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String address;
	private String city;
	private String state;
	private int pinCode;
	private LocalDate createdOn;
	private LocalDate lastModifiedOn;
	private int version;

	public Users() {

	}

	public Users(String firstName, String lastName, String email, String mobile, String address, String city,
			String state, int pinCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getuser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(LocalDate lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", address=" + address + ", city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + ", createdOn=" + createdOn + ", lastModifiedOn=" + lastModifiedOn + ", version=" + version
				+ "]";
	}
}