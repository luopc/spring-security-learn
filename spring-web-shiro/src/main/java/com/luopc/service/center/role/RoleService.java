package com.luopc.service.center.role;

import java.util.List;
import java.util.Set;

import com.luopc.base.center.role.model.Role;

public interface RoleService {

	List<Role> selectRoleCollectionByUserId(String id);
	
	List<Role> selectAllRoles();

}
