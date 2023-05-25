package com.yash.ytms.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ytms.dto.ServerResponse;
import com.yash.ytms.entity.User;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user){
		return new ResponseEntity<User>(userService.register(user), HttpStatus.CREATED);
	}
	
    @PostMapping("/auth")
    public ResponseEntity<ServerResponse> generateToken(@RequestBody HashMap<String, String> credentials){
    	System.out.println(credentials.toString());
    	return new ResponseEntity<ServerResponse>(userService.generateToken(credentials), HttpStatus.OK);
    }
    
    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) throws UserNotFound{
    	System.out.println("User id is :"+id);
    	return new ResponseEntity<User>(userService.getById(id), HttpStatus.FOUND);
    }
}
