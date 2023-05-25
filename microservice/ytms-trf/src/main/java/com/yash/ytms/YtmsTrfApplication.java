package com.yash.ytms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YtmsTrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtmsTrfApplication.class, args);
	}

}
