package com.yash.ytms.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.yash.ytms.entity.User;
import com.yash.ytms.exception.UserNotFound;

@Service
public interface UserService {

	User getById(Long id) throws UserNotFound;
}
