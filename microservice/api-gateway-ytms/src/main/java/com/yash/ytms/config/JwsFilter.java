package com.yash.ytms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;


import reactor.core.publisher.Mono;

/**
 * JWS Filter
 * If authorization header exists, will set to security context
 *
 * @author seliote
 * @since 2022-07-06
 */
@Component
public class JwsFilter implements WebFilter {
	
    @Autowired
    private JwtUtil jwtUtil;
    
    
	@Autowired
	MyUserDetailService userDetailService;
    
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		final ServerHttpRequest request = exchange.getRequest();
		final HttpHeaders authorizationHeader = request.getHeaders();
		final String header = authorizationHeader.getFirst("Authorization");
		String username = null;
		String jwt = null;
		if (header!= null && header.startsWith("Bearer ")) {
			jwt = header.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

			if (jwtUtil.checkToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				return chain.filter(exchange)
                .contextWrite(ReactiveSecurityContextHolder.withAuthentication(usernamePasswordAuthenticationToken));
            }
		}
		return chain.filter(exchange);
	}
}