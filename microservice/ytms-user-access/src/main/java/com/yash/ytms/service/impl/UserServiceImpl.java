package com.yash.ytms.service.impl;

import java.util.HashMap;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ytms.entity.User;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.repository.UserRepository;
import com.yash.ytms.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User getById(Long id) throws UserNotFound {
		User user = userRepo.findById(id).orElseThrow(()-> new UserNotFound("Not Found"));
		System.out.println("User is :" + user.toString());
		return user;
	}
	


}
