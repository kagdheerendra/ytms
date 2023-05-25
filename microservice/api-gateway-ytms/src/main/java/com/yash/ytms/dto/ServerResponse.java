package com.yash.ytms.dto;

import org.springframework.security.core.userdetails.UserDetails;

import com.yash.ytms.entity.User;

public class ServerResponse {

	private String accessToken;
	private UserDetails user;
	public ServerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServerResponse(String accessToken, UserDetails user) {
		super();
		this.accessToken = accessToken;
		this.user = user;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	
}
