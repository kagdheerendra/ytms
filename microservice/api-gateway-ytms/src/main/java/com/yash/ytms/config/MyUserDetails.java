package com.yash.ytms.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yash.ytms.entity.Permission;
import com.yash.ytms.entity.User;

/**
 * will hold the current login user detail for generate the jwt token.
 * @author dheerendra.kag
 *
 */
public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	private List<Permission> permissions;

	public MyUserDetails(User user) {
		super();
		this.userName = user.getEmail();
		this.password = user.getPassword();
		this.active = true;
		this.authorities = user.getRoles().stream().map((s) -> new SimpleGrantedAuthority(s.getRoleName()))
				.collect(Collectors.toList());
		this.permissions = user.getRoles().stream().map(r->r.getPermissions()).collect(Collectors.toList()).get(0);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "MyUserDetails [userName=" + userName + ", password=" + password + ", active=" + active
				+ ", authorities=" + authorities + ", permissions=" + permissions + "]";
	}


}
