package com.yash.ytms.service.impl;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.ytms.Repository.UserRepository;
import com.yash.ytms.config.JwtUtil;
import com.yash.ytms.config.MyUserDetailService;
import com.yash.ytms.dto.ServerResponse;
import com.yash.ytms.entity.User;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	private ReactiveAuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtutil;
	
	@Override
	public User register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public ServerResponse generateToken(HashMap<String, String> credential) {
		ServerResponse res =  new ServerResponse();
		final String email = credential.get("email");
		final String password = credential.get("password");
		final UserDetails userDetails = userDetailService.loadUserByUsername(email);
		System.out.println("from serviceimpl : "+userDetails.toString());
		final String jwt = jwtutil.generateToken(userDetails);

		res.setAccessToken(jwt);
		res.setUser(userDetails);
		return res;
	}

	@Override
	public User getById(Long id) throws UserNotFound {
		User user = userRepository.findById(id).orElseThrow(()-> new UserNotFound("Not Found"));
		System.out.println("User is :" + user.toString());
		return user;
	}

}
