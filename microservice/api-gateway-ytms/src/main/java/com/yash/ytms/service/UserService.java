package com.yash.ytms.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.yash.ytms.dto.ServerResponse;
import com.yash.ytms.entity.User;
import com.yash.ytms.exception.UserNotFound;

@Service
public interface UserService {

	User register(User user);
	ServerResponse generateToken(HashMap<String, String> credential);
	User getById(Long id) throws UserNotFound;
}
