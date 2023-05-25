package com.yash.ytms.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class Permission implements Serializable{

	private static final long serialVersionUID = 5649871670412037891L;

	@Id
	@Column(name = "permission_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long permissionId;

	@Column(name = "permission_name")
	private String permissionName;

	public Permission() {
		super();
	}

	public Permission(Long permissionId, String permissionName) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + "]";
	}
}
