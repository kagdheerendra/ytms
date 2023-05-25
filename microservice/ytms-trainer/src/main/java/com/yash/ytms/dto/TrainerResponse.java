package com.yash.ytms.dto;

import com.yash.ytms.entity.Trainer;

public class TrainerResponse {

	private String message;
	private Trainer trainer;
	public TrainerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainerResponse(String message, Trainer trainer) {
		super();
		this.message = message;
		this.trainer = trainer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "TrainerResponse [message=" + message + ", trainer=" + trainer + "]";
	}
	
	
}
