package com.yash.ytms.external.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.yash.ytms.dto.User;

import feign.FeignException;


@FeignClient(name="YTMS-USER-ACCESS", url = "${USERACCESS.url}")
public interface ExternalUserService {

	@GetMapping("/useraccess/getById/{id}")
	User getById(@PathVariable("id") Long id) throws FeignException;
}

