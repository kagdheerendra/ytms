package com.yash.ytms.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class User implements Serializable{

	private static final long serialVersionUID = -7309031366006101779L;

	private Long userId;

	private String empId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String mobile;

	private String gender;

	private Date dobDate;

	private String experience;

	private String location;

	private String project;

	private String designation;

	private LocalDateTime createdDate;

	private LocalDateTime modifiedDate;

    private List<Role> roles = new ArrayList<>();

	public User() {
		super();
	}

	public User(Long userId, String empId, String firstName, String lastName, String email, String password,
			String mobile, String gender, Date dobDate, String experience, String location, String project,
			String designation, LocalDateTime createdDate, LocalDateTime modifiedDate, List<Role> roles) {
		super();
		this.userId = userId;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.gender = gender;
		this.dobDate = dobDate;
		this.experience = experience;
		this.location = location;
		this.project = project;
		this.designation = designation;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDobDate() {
		return dobDate;
	}

	public void setDobDate(Date dobDate) {
		this.dobDate = dobDate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", mobile=" + mobile + ", gender=" + gender
				+ ", dobDate=" + dobDate + ", experience=" + experience + ", location=" + location + ", project="
				+ project + ", designation=" + designation + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", roles=" + roles + "]";
	}
    
    
}
