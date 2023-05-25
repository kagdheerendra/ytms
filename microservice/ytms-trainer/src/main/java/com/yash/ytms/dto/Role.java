package com.yash.ytms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Role implements Serializable{

    private static final long serialVersionUID = -8185503523433107338L;

	private Long roleId;

	private String roleName;
	
	
    private List<Permission> permissions = new ArrayList<>();


	public Role() {
		super();
	}


	public Role(Long roleId, String roleName, List<Permission> permissions) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.permissions = permissions;
	}


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public List<Permission> getPermissions() {
		return permissions;
	}


	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}


	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", permissions=" + permissions + "]";
	}

    
}
