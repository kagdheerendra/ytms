package com.yash.ytms.entity;

import java.io.Serializable;
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

@Entity
public class Role implements Serializable{

    private static final long serialVersionUID = -8185503523433107338L;

	@Id
	@Column(name = "role_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;

	@Column(name = "role_name")
	private String roleName;
	
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_permission_id", referencedColumnName = "role_Id")
    private List<Permission> permissions;


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
