package com.yash.ytms.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {

	@Id
	@Column(name = "trainer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainerId;

	@Column(name = "user_id")
    private Long userId;

	@Column(name = "current_location")
	private String currentLocation;

	@Column(name = "base_location")
	private String baseLocation;

	@Column(name = "irm")
	private String irm;

	@Column(name = "type")
	private String type;

	@Column(name = "total_experience")
	private String totalExperience;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(Long trainerId, Long userId, String currentLocation, String baseLocation, String irm, String type,
			String totalExperience, LocalDateTime createdOn, LocalDateTime updatedOn) {
		super();
		this.trainerId = trainerId;
		this.userId = userId;
		this.currentLocation = currentLocation;
		this.baseLocation = baseLocation;
		this.irm = irm;
		this.type = type;
		this.totalExperience = totalExperience;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getIrm() {
		return irm;
	}

	public void setIrm(String irm) {
		this.irm = irm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", userId=" + userId + ", currentLocation=" + currentLocation
				+ ", baseLocation=" + baseLocation + ", irm=" + irm + ", type=" + type + ", totalExperience="
				+ totalExperience + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}

	
}
