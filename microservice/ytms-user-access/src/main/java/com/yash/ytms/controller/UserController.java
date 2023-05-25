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

import com.yash.ytms.entity.User;
import com.yash.ytms.exception.UserNotFound;
import com.yash.ytms.service.UserService;

@RestController
@RequestMapping("/useraccess")
public class UserController {

	@Autowired
	private UserService userService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) throws UserNotFound{
    	return new ResponseEntity(userService.getById(id), HttpStatus.OK);
    }
}
