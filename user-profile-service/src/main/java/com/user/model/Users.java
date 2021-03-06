package com.user.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Users {
	@Id
	private String id;
	@Field
	private String fullName;
	@Field
	private String role;
	@Field
	private String email;
	@Field
	private String username;
	@Field
	private String password;
	@Field
	private String gender;
	@Field
	private String about;
	@Field
	private String dateOfBirth;
	@Field
	private Long mobileNumber;
	@Field
	private List<String> address;
	
	
	public Users() {}

	public Users(String fullName, String role,String email,String username, String password,String gender, String about,String dateOfBirth, Long mobileNumber, List<String> address) {
		super();
		this.fullName = fullName;
		this.role = role;
		this.email=email;
		this.gender=gender;
		this.about=about;
		this.mobileNumber=mobileNumber;
		this.address=address;
		this.username=username;
		this.password=password;
		this.dateOfBirth=dateOfBirth;
		}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
		
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
	return "user [id=" + id + ", fullName=" + fullName + ", role=" + role + ", email=" + email +
			 ", gender=" + gender + ", about=" + about +", mobileNumber=" + mobileNumber +", address=" + address +"]";
	}
	
}
