package com.luopc.base.center.user.model;

import java.util.Set;

import com.luopc.base.center.role.model.Role;

public class UserWithRoles extends User {

	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}