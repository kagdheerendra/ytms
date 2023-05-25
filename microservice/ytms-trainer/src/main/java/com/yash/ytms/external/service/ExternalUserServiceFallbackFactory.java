package com.yash.ytms.external.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.yash.ytms.dto.User;

import feign.FeignException;

@Component
public class ExternalUserServiceFallbackFactory implements FallbackFactory<ExternalUserService> {
    @Override
    public ExternalUserService create(Throwable cause) {

     System.out.println("inside fallback factory");
     String httpStatus = cause instanceof FeignException ? Integer.toString(((FeignException) cause).status()) : "";
     System.out.println("inside fallback factory"+httpStatus);
     return new ExternalUserService() {
	        @Override
	        public User getById(Long id) {
	        	return new User();
	        }
        };
    };
}
