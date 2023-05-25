package com.yash.ytms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yash.ytms.dto.User;
import com.yash.ytms.entity.Trainer;
import com.yash.ytms.exception.TrainerNotFound;
import com.yash.ytms.external.service.ExternalUserService;
import com.yash.ytms.repository.TrainerRepository;
import com.yash.ytms.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	DiscoveryClient client;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private TrainerRepository repo;
	
	@Autowired 
	private ExternalUserService externalUserService;
	
	@Override
	public List<Trainer> getTrainers() {
		return repo.findAll();
	}

	@Override
	public Trainer getTrainer(Long trainerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer saveTrainerDetails(Trainer trainer) {
		User obj = externalUserService.getById(trainer.getUserId());
		if(obj.getUserId() == null) {
			throw new TrainerNotFound("User not found for given id: "+trainer.getUserId());
		}
		Trainer tr = new Trainer();
		System.out.println("---------||--------"+obj.toString());
		tr = repo.save(trainer);
		return tr;
	}
}
