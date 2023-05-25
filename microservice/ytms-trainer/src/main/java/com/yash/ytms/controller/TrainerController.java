package com.yash.ytms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yash.ytms.dto.TrainerResponse;
import com.yash.ytms.entity.Trainer;
import com.yash.ytms.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	@PostMapping("/save")
	@HystrixCommand(fallbackMethod = "saveDetailsFallBackMethod", commandProperties = {
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "2"),
			@HystrixProperty(name="circuitBreaker.enabled", value="true")
	})
	public ResponseEntity<TrainerResponse> saveDetails(@RequestBody Trainer trainer){
		Trainer t = trainerService.saveTrainerDetails(trainer);
		TrainerResponse res = new TrainerResponse();
		res.setMessage("Created");
		res.setTrainer(t);
		return new ResponseEntity<TrainerResponse>(res, HttpStatus.CREATED);
	}
	
	public ResponseEntity<TrainerResponse> saveDetailsFallBackMethod(@RequestBody Trainer trainer){
		return new ResponseEntity<TrainerResponse>(new TrainerResponse("Please try later..", new Trainer()), HttpStatus.OK);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Trainer>> getAllTrainerDetails(){
		return new ResponseEntity<List<Trainer>>(trainerService.getTrainers(), HttpStatus.OK);
	}
}
