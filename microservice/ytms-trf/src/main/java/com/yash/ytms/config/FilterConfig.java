package com.yash.ytms.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	
    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
    	System.out.println("Hello..");
        FilterRegistrationBean<JwtFilter> filter= new FilterRegistrationBean<JwtFilter>();
        filter.setFilter(new JwtFilter());

//        provide endpoints which needs to be restricted.
//        All Endpoints would be restricted if unspecified
        filter.addUrlPatterns("/trf/**");
        return filter;
    }
}
