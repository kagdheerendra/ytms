package com.yash.ytms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

/**
 * configure the spring security.
 * @author dheerendra.kag
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {
	
	private final JwsFilter jwsFilter;
	
    @Autowired
    public SecurityConfiguration(JwsFilter jwsFilter) {
        this.jwsFilter = jwsFilter;
    }
	
    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        final String[] permitAll = new String[]{"/user/**", "/actuator/**"};
        String[] roles = {"USER","ADMIN"};
        return http.csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .authorizeExchange().pathMatchers(permitAll).permitAll()
                .pathMatchers("/trf/**").hasAnyRole("ADMIN")
                .pathMatchers("/trainer/**").hasAnyRole("USER")
                .pathMatchers("/useraccess/**").hasAnyRole(roles)
                .anyExchange().authenticated()
                .and().addFilterAt(jwsFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }
    
    @Bean
    public ReactiveAuthenticationManager authenticationManager() {
    	return authentication -> Mono.empty();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}
